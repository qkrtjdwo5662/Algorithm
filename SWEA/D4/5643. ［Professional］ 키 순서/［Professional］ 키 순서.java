import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int answer;
	static boolean[] visited;
	
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 학생 수
			
			ArrayList<Integer>[] graph = new ArrayList[n + 1];
			ArrayList<Integer>[] graphReverse = new ArrayList[n + 1];
			
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
				graphReverse[i] = new ArrayList<>();
				
			}
			
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 비교 횟수
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graphReverse[b].add(a);
			}
			
			answer = 0;
			
			
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				
				// i -> ?
				
				visited = new boolean[n + 1];
				visited[i] = true;
				count = 0;
				dfs(i, graph, i);
				sum += count;
				
				// ? -> i
				count = 0;
				dfs(i, graphReverse, i);
				sum += count;
	
				
				if(sum  == n - 1) answer++;
				
			
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int now, ArrayList<Integer> graph[], int start) {
		for (int i = 0; i < graph[now].size(); i++) {
			
			int next = graph[now].get(i);
			
//			if(start == 4) {
//				System.out.println(next);
//			}
//			
			if(!visited[next] && next != start) {
				visited[next] = true;
				count++;
				dfs(next, graph, start);
				
			}
		}
	}
	
//	static void startDfs(int now, ArrayList<Integer> graph[]) {
//		if(visited[now]) return;
//		visited[now] = true;
//		
//		count ++;
//		
//		for (int i = 0; i < graph[now].size(); i++) {
//			 graph[now].size()
//			startDfs(next, graph);
//		}
//		
//		
//	}
	
//	static void targetDfs(int now, int target) {
//		if(now == target) {
//			endCount ++;
//			return;
//		}
//		
//		if(visited[now]) return;
//		visited[now] = true;
//		
//		
//		for (int i = 0; i < graph[now].size(); i++) {
//			int next = graph[now].get(i);
//			targetDfs(next, target);
//		}
//		
//	}
	
	
}