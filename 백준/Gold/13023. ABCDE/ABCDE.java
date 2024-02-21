import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n];
		
		flag = false;
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(0, i);
			visited[i] = false;
		}
		
		if(flag) {
			sb.append(1).append("\n");
		}else sb.append(0).append("\n");
		System.out.println(sb);
		
	}
	
	static void dfs(int depth, int now) {
		if(flag) return;
		
		if(depth == 4) {
			flag = true;
			return;
		}
		
		for (int i = 0; i < adjList[now].size(); i++) {
			int next = adjList[now].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(depth + 1, next);
				visited[next] = false;
			}
		}
	}
	
	
}