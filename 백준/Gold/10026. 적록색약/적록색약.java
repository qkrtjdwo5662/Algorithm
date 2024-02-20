import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] board;
	static boolean[][] visited;
	
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		board = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		visited = new boolean[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					normal(new int[] {i, j}, board[i][j]);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		
		visited = new boolean[n][n];
		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					blindColor(new int[] {i, j}, board[i][j]);
					count++;
				}
			}
		}
		sb.append(count).append("\n");
//		
		System.out.println(sb);
	}
	static void normal(int[] start, char color) {
		visited[start[0]][start[1]] = true;
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		
		deque.addLast(start);
		
		while(!deque.isEmpty()) {
			int[] now =deque.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c<0 || r>= n || c>= n) continue;
				
				if(board[r][c] != color) continue;
				
				if(!visited[r][c]) {
					visited[r][c] = true;
					deque.addLast(new int[] {r, c});
				}
			}
			
		}
		
	}
	
	static void blindColor(int[] start, char color) {
		visited[start[0]][start[1]] = true;
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		
		deque.addLast(start);
		
		while(!deque.isEmpty()) {
			int[] now =deque.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c<0 || r>= n || c>= n) continue;
				
				if(color == 'R') {
					if(board[r][c] == 'B' ) continue;
				}else if(color == 'G') {
					if(board[r][c] == 'B' ) continue;
				}else if(color == 'B') {
					if(board[r][c] != 'B' ) continue;
				}
				
				
				if(!visited[r][c]) {
					visited[r][c] = true;
					deque.addLast(new int[] {r, c});
				}
			}
			
		}
	}
}