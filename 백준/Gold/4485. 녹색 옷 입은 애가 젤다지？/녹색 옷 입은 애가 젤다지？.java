import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int y;
		int x;
		int cost;
		
		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
	static int[][] board;
	static int n;
	static boolean[][] visited;
	static final int INF = 987654321;
	static int[] ry = {1, -1, 0, 0};
	static int[] rx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = 0;
		int tc = 0;
		
		while((n = Integer.parseInt(br.readLine())) != 0) {
			tc ++;
			board = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
				}
			}
			
		
			sb.append("Problem ").append(tc).append(": ").append(dijkstra()).append("\n");
		}
		System.out.println(sb);
	}
	
	static int dijkstra() {
		visited = new boolean[n][n];
		int[][] dist = new int[n][n];
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> {
			return Integer.compare(o1.cost, o2.cost);
		});
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = INF;
			}
		}
		pq.add(new Node(0, 0, board[0][0]));
		dist[0][0] = board[0][0];
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.y][now.x]) continue;
			visited[now.y][now.x] = true;
			
			for (int i = 0; i < 4; i++) {
				int r = now.y + ry[i];
				int c = now.x + rx[i];
				
				if(r < 0 || c < 0 || r>= n || c>= n) continue;
				
				if(dist[r][c] > dist[now.y][now.x] + board[r][c]) {
					dist[r][c] = dist[now.y][now.x] + board[r][c];
					pq.add(new Node(r, c, dist[r][c]));
				}
			}
		}
		
		return dist[n-1][n-1];
		
	}
}