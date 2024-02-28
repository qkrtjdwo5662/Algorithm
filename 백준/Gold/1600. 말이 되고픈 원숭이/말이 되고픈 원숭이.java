import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 원숭
	static int[] ry = {1, -1, 0, 0};
	static int[] rx = {0, 0, 1, -1};
	
	// 말
	static int[] rry = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] rrx = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static int n;
	static int m;
	static int[][] board;
	static int k;
	static int[][] dist;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
			}
		}

		if(n==1 && m == 1) {
			sb.append(0).append("\n");
			System.out.println(sb);
			return;
		}
		
		dist = new int[n][m];
		visited = new boolean[n][m][k + 1];
		bfs();
		
		
		if(dist[n-1][m-1] == 0) {
			sb.append(-1).append("\n");
		}else {
			sb.append(dist[n-1][m-1]).append("\n");
		}
		
		System.out.println(sb);
		// 0 빈칸, 1 장애물
		
	}
	
	static void bfs() {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] {0, 0, k});
 		visited[0][0][k] = true;
 		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			if(now[0] == n-1 && now[1] == m-1) return;
			
			int count = now[2];

			if(count > 0) {
				for (int i = 0; i < 8; i++) {
					int r = now[0] + rry[i];
					int c = now[1] + rrx[i];
					
					if(r < 0 || c < 0 || r>= n || c>= m) continue;
					
					if(board[r][c] == 1) continue;
					
					if(!visited[r][c][count - 1]) {
						visited[r][c][count - 1] = true;
						deque.addLast(new int[] {r,c, count - 1});
						dist[r][c] = dist[now[0]][now[1]] + 1;
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c < 0 || r>= n || c>= m) continue;
				
				if(board[r][c] == 1) continue;
				
				if(!visited[r][c][count]) {
					visited[r][c][count] = true;
					deque.addLast(new int[] {r,c, count});
					dist[r][c] = dist[now[0]][now[1]] + 1;
				}
			}
			
			
		}
	}
}