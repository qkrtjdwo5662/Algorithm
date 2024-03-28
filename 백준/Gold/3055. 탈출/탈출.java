import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	
	static char[][] board;
	static boolean[][] visited;
	
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	
	static ArrayDeque<int[]> deque;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		visited = new boolean[n][m];
		deque = new ArrayDeque<>();
		
		int gy = -1;
		int gx = -1;
		
		int endY = -1;
		int endX = -1;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
				
				if(board[i][j] == 'S') { // 도치 위치요 
					gy = i;
					gx = j;
					board[i][j] = '.';
				}else if(board[i][j] == 'D') { // 굴 위치요
					endY = i;
					endX = j;
				}else if(board[i][j] == '*') { // 물 위치요
					deque.addLast(new int[] {i, j, 0, -1});
					visited[i][j] = true;
				}
			}
		}
		
		// 물이 이동하고 고슴도치가 이동한다
		
		
		
//		print();
		
		int answer = bfs(gy, gx, endY, endX);
//		print();
		
		if(answer == -1) {
			sb.append("KAKTUS").append("\n");
			System.out.println(sb);
		}else {
			sb.append(answer).append("\n");
			System.out.println(sb);
		}
	}
	
	static int bfs(int gy, int gx, int endY, int endX) {

		visited[gy][gx] = true;
		deque.addLast(new int[] {gy, gx, 0 , 1}); // 도치는 1
		
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			int ny = now[0];
			int nx = now[1];
			int dist = now[2];
			int status = now[3];
			
//			System.out.println(ny + " " + nx);
			
			if(ny == endY && nx == endX && status == 1) return dist;
			
			for (int i = 0; i < 4; i++) {
				int r = ny + ry[i];
				int c = nx + rx[i];
				
				if( r < 0 || c < 0 || r>= n || c>= m) continue;
				
				if(board[r][c] == 'X') continue; // 돌 (공통)
				
				if(status == -1) { // 물이면
					//
					if(board[r][c] == 'D') continue; //굴
					
					if(board[r][c] == '*') continue; // 이미 물
					
					board[r][c] = '*';
					deque.addLast(new int[] {r, c, dist + 1, status});
					
				}else if(status == 1) { // 도치면
					if(board[r][c] == '*') continue; // 물
					
					if(visited[r][c]) continue;
					
					visited[r][c] = true;
					deque.addLast(new int[] {r, c, dist + 1, status});
				}
				
				
			}
			
		}
		
		
		
		return -1;
		
	}
	
	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}