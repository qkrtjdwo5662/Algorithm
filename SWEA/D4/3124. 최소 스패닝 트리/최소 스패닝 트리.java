import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Node {
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	
	static ArrayList<Node>[] adjList;
	static boolean[] visited;
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken()); // 정점 수 
			int e = Integer.parseInt(st.nextToken()); // 간선 수 
			
			adjList = new ArrayList[v + 1];
			visited = new boolean[v + 1];
			for (int j = 1; j <= v ; j++) {
				adjList[j] = new ArrayList();
			}
			
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				adjList[start].add(new Node(end, cost));
				adjList[end].add(new Node(start, cost));
			}
			answer = 0;
			
			prim(1);
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->{
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