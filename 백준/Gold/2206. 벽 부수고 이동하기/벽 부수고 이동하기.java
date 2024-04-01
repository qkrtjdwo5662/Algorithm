import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] board;
	
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 1; j <= m; j++) {
				board[i][j] = s.charAt(j - 1) - '0';
			}
		}
		
		int answer = bfs();
		sb.append(answer).append("\n");
		System.out.println(sb);
		
		
	}
	static int bfs() {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] {1, 1, 0, 1});
		boolean[][][] visited = new boolean[n + 1][m + 1][2];
		visited[1][1][0] = true;
		
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			int y = now[0];
			int x = now[1];
			int broken = now[2];
			int dist = now[3];
			
//			System.out.println(y + " "  + x + " " + broken + " " + dist);
			
			if(y == n && x == m) return dist;
			
			for (int i = 0; i < 4; i++) {
				int r = y + ry[i];
				int c = x + rx[i];
				
				if(r < 1 || c < 1 || r > n || c > m) continue;
				
				if(board[r][c] == 1) {
					if(broken == 1) continue;
					else if(broken == 0) {
						if(!visited[r][c][broken + 1]) {
							visited[r][c][broken + 1] = true;
							deque.addLast(new int[] {r, c, 1, dist + 1});
						}
					}
				}else if(board[r][c] == 0) {
					if(!visited[r][c][broken]) {
						visited[r][c][broken] = true;
						deque.addLast(new int[] {r, c, broken, dist + 1});
					}
				}
				
			}
			
		}
		
		return -1;
	}
}