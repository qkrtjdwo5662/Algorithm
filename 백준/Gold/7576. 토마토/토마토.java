import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int n;
	static int[][] board;
	static boolean[][] visited;
	static ArrayDeque<int[]> deque;
	
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		visited = new boolean[n][m];
		deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;

				if(num == 1) {
					visited[i][j] = true;
					deque.addLast(new int[] {i, j});
					
				}
			}
		}
		
		// 1 익은 토마토
		// 0 익지 않은 토마토
		// -1 토마토가 들어있지 않음

		
		
		// 익지 않은 토마토 부터 시작
		bfs();
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j] == 0) {
					sb.append(-1).append("\n");
					System.out.println(sb);
					return;
				}
				
				answer = Math.max(answer, board[i][j]);
			}
		}
		sb.append(answer - 1).append("\n");
		System.out.println(sb);
	
		
	}
	static void bfs() {
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c < 0 || r>= n || c>= m) continue;
				
				if(board[r][c] != 0 ) continue;
				
				if(!visited[r][c]) {
					visited[r][c] = true;
					deque.addLast(new int[] {r, c});
					board[r][c] = board[now[0]][now[1]] + 1;
				}
			}
			
		}
		
	}
}