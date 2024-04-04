import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] board;
	
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	
	static int[][] dist;
	static boolean[][] visited;
	
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			board = new int[n][n];
			
			dist = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				for (int j = 0; j < n; j++) {
					board[i][j] = s.charAt(j) - '0';
				}
			}
			
			int answer = dijkstra(0, 0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static int dijkstra(int y, int x) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = INF;
			}
		}
		
		
		dist[y][x] = board[y][x];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return Integer.compare(o1[2], o2[2]);
		});
				
		
		pq.add(new int[] {y, x, board[y][x]});

		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			int ny = now[0];
			int nx = now[1];
			int w = now[2];
			
			if(visited[ny][nx]) continue;
			visited[ny][nx] = true;
			
			for (int i = 0; i < 4; i++) {
				int r = ny + ry[i];
				int c = nx + rx[i];
				
				if( r < 0 || c < 0 || r >= n || c>= n) continue;
				
				if(dist[r][c] > dist[ny][nx] + board[r][c]) {
					dist[r][c] = dist[ny][nx] + board[r][c];
					pq.add(new int[] {r, c, dist[r][c]});
				}
			}
		}
		
		
		return dist[n-1][n-1];
	}
}