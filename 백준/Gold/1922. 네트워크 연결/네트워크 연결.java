import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static ArrayList<Node>[] adjList;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n+1]; 
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Node(v, cost));
			adjList[v].add(new Node(u, cost));
		}
		
		visited = new boolean[n+1];
		answer = 0;
		prim(1);
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	
	static void prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->  {
			return Integer.compare(o1.cost, o2.cost);
		});
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.end]) continue;
			visited[now.end] = true;
			
			answer += now.cost;
			
			for (int i = 0; i < adjList[now.end].size(); i++) {
				Node next = adjList[now.end].get(i);
				
				if(!visited[next.end]) {
					pq.add(next);
				}
			}
		}
		
	}
}