import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		visited = new boolean[n + 1];  
		answer = 0;
		
		dfs(1);
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	
	static void dfs(int now) {
		if(visited[now]) return;
		visited[now] = true;
		
		for (int i = 0; i < adjList[now].size(); i++) {
			int next = adjList[now].get(i);
			
			if(!visited[next]) {
				answer += 1;
				dfs(next);
			}
		}
	}

}