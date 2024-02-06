import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] board;
	static int[] rx = {0, 0, 1, -1};
	static int[] ry = {1, -1, 0, 0};
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		int answer = 0;
		int temp = 0;
		while(true) {
			outAir();
			list = new ArrayList<>();
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if(board[i][j] == 1 ) {
						if(isMelt(new int[] {i, j})) {
							list.add(new int[] {i, j});
						}
					}
					
				}
			}
			
			if(list.size() == 0) {
				sb.append(answer).append("\n").append(temp).append("\n");
				System.out.println(sb);
				return;
			}else {
				temp = list.size();
				for (int i = 0; i < list.size(); i++) {
					int[] now = list.get(i);
					board[now[0]][now[1]] = 0;
				}
			}
			
			answer++;
		}
		
		
		
	}
	
	static boolean isMelt(int[] now) {
		int count = 0;
		
		for (int i = 0; i < 4; i++) {
			int r = now[0] + ry[i];
			int c = now[1] + rx[i];
			
			if(r < 0 || c<0 || r >= n || c>=m ) continue;
			
			if(board[r][c] == 2) count++;
		}
		
		return count >= 1;
	}
	
	static void outAir() {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		
		board[0][0] = 2;
		visited[0][0] = true;
		
		deque.addLast(new int[] {0, 0});
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c<0 || r>= n || c>=m) continue;
				
				if(board[r][c] == 1) continue;
				
				if(!visited[r][c]) {
					visited[r][c] = true;
					board[r][c] = 2;
					deque.addLast(new int[] {r,c});
				}
			}
		}
	}
	
	
}