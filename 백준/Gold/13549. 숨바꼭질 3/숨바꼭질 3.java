import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int to;
		int second;
		
		public Node(int to, int second) {
			this.to = to;
			this.second = second;
		}
	}
	static int n;
	static int k;
	
	static final int size = 100_000;
	static final int INF = 98765421;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		sb.append(dijkstra(n)).append("\n");
		System.out.println(sb);
	}
	
	static int dijkstra(int start) {
		boolean[] visited = new boolean[size + 1];
		int[] dist = new int[size + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->{
			return Integer.compare(o1.second, o2.second);
		});
		
		
		pq.add(new Node(start, 0));
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.to == k) return dist[now.to];
			
			if(visited[now.to]) continue;
			visited[now.to] = true;
			
			for (int i = 0; i < 3; i++) {
				int to = now.to;
				if(i == 0) {
					if(to - 1 < 0) continue;
					
					if(dist[to - 1] > dist[to] + 1) {
						dist[to - 1] = dist[to] + 1;
						pq.add(new Node(to-1, dist[to-1]));
					}
					
				}else if(i == 1) {
					if(to + 1 > size) continue;
					
					if(dist[to + 1] > dist[to] + 1) {
						dist[to + 1] = dist[to] + 1;
						pq.add(new Node(to + 1, dist[to+1]));
					}

				}else if(i == 2) {
					if(to * 2 > size) continue;
					
					if(dist[to * 2] > dist[to]) {
						dist[to * 2] = dist[to];
						pq.add(new Node(to * 2, dist[to * 2]));
					}
				}
			}
			
		}
		return dist[k];
		
		
		
		
	}
}