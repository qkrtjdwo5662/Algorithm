import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static int startY;
	static int startX;
	static int status;
	static int endY;
	static int endX;
	
	static int[] ry = {0, 1, 0, -1};
	static int[] rx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		
		ArrayList<int[]> start = new ArrayList<>();
		ArrayList<int[]> end = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == 'B') {
					start.add(new int[] {i, j});
				}else if(s.charAt(j) == 'E') {
					end.add(new int[] {i, j});
				}else board[i][j] = s.charAt(j) - '0';
			}
		}
		
		startY =  start.get(1)[0];
		startX = start.get(1)[1];
		
		endY = end.get(1)[0];
		endX = end.get(1)[1];
		
		
		int status = -1;
		
		if(start.get(0)[0] == start.get(1)[0]) {
			status = 0; // 가로로 누움
		}else status = 1; // 세로로 누움
		
		
//		System.out.println(startY + " " + startX);
//		System.out.println(endY + " " + endX);
//		System.out.println(Arrays.deepToString(board));
		
		int answer = bfs(startY, startX, status);
		
		System.out.println(answer);
		
	}
	
	static int bfs(int y, int x, int status) {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		boolean[][][] visited = new boolean[n][n][2];
		visited[y][x][status] = true;
		
		deque.addLast(new int[] {y, x, status, 0});
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			int ny = now[0];
			int nx = now[1];
			int nStatus = now[2];
			int d = now[3];
			
			if(ny == endY && nx == endX) return d;
			
			for (int i = 0; i < 5; i++) {
				if(i < 4) {
					int r = ny + ry[i];
					int c = nx + rx[i];
					
					if(r < 0 || c < 0 ||  r>= n || c>= n ) continue;
					
					if(board[r][c] == 1) continue;
					
					if(!canMove(nStatus, r, c)) continue;
					
					if(!visited[r][c][nStatus]) {
						visited[r][c][nStatus] = true;
						deque.addLast(new int[] {r, c, nStatus, d + 1});
					}
				}else {
					if(!canRotate(nStatus, ny, nx)) continue;
					
					if(!visited[ny][nx][(nStatus + 1) % 2]) {
						visited[ny][nx][(nStatus + 1) % 2] = true;
						deque.addLast(new int[] {ny, nx, (nStatus + 1) % 2, d + 1});
					}
					
				}
				
			}
			
		}
		
		
		return 0;

	}
	static boolean canMove(int status, int y, int x) {
		int y1 = y + ry[(status + 2)  % 4];
		int x1 = x + rx[(status + 2)  % 4];
		
		int y3 = y + ry[(status)  % 4];
		int x3 = x + rx[(status)  % 4];
		
		if(y1 < 0 || x1 < 0 || y1 >= n || x1>= n || y3 < 0 || x3 < 0 || y3>= n || x3 >= n) return false;
		
		if(board[y1][x1] == 1 || board[y3][x3] == 1) return false;
		
		return true;
	}
	
	static boolean canRotate(int status, int y, int x) {
		ArrayList<int[]> list = new ArrayList<>();
		
		int y1 = y + ry[(status + 2)  % 4];
		int x1 = x + rx[(status + 2)  % 4];
		
		int y3 = y + ry[(status)  % 4];
		int x3 = x + rx[(status)  % 4];
		
		if(y1 < 0 || x1 < 0 || y1 >= n || x1>= n || y3 < 0 || x3 < 0 || y3>= n || x3 >= n) return false;
		
		list.add(new int[] {y1, x1});
		list.add(new int[] {y, x});
		list.add(new int[] {y3, x3});
		
		for (int i = 0; i < list.size(); i++) {
			int[] now = list.get(i);
			
			for(int j=1; j<=3; j+=2) {
				int r = now[0] + ry[(status + j) % 4];
				int c = now[1] + rx[(status + j) % 4];
				
				if(r < 0 || c< 0 || r>= n || c>= n) return false;
				
				if(board[r][c] == 1) return false;
			}
			
		}
		
		return true;
		
	}
}