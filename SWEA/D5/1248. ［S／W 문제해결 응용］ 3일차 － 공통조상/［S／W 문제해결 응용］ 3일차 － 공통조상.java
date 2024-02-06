import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken()); 
			int m = Integer.parseInt(st.nextToken()); 
			
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			
			adjList = new ArrayList[n+1];

			for (int j = 1; j <= n; j++) {
				adjList[j] = new ArrayList<>();
			}
			
			int[] parents = new int[n+1];
			
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				adjList[u].add(v);
				parents[v] = u;
			}
			
			
			int common = findParent(a, b, parents);
			int answer = getSize(common);
			sb.append("#").append(i).append(" ");
			sb.append(common).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static int findParent(int a, int b, int[] parents) {
		boolean[] visited = new boolean[n+1];
		
		while(a != 0) {
			visited[a] = true;
			a = parents[a];
		}
		
		while(b != 0) {
			if(visited[b]) {
				return b;
			}
			b = parents[b];
		}
		
		
		return 1;
	}
	
	static int getSize(int start) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		
		deque.addLast(start);
		visited[start] = true;
		
		int count = 0;
		
		while(!deque.isEmpty()) {
			int now = deque.pollFirst();
			
			count++;
			for (int i = 0; i < adjList[now].size(); i++) {
				int next = adjList[now].get(i);
				
				if(!visited[next]) {
					visited[next] = true;
					deque.addLast(next);
	
				}
				
			}
		}
		return count;
	}
}