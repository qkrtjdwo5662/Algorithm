import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int n;
	static ArrayList<Node>[] adjList;
	static final int MAX = 987654321;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n + 1];
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Node(v, c));
		}
		
		dijkstra(start);
		
		for (int i = 1; i <= n; i++) {
			if(dist[i] == MAX) {
				sb.append("INF").append("\n");
			}else sb.append(dist[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[n + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return Integer.compare(o1.cost, o2.cost);
		});
		
		dist = new int[n + 1];
		Arrays.fill(dist, MAX);
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.end]) continue;
			visited[now.end] = true;
			
			for (int i = 0; i < adjList[now.end].size(); i++) {
				Node next = adjList[now.end].get(i);
				
				if(dist[next.end] > dist[now.end] + next.cost ) {
					dist[next.end] = dist[now.end] + next.cost;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
			
		}
		
	}
}