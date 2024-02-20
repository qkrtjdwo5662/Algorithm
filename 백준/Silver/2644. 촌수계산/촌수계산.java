import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] adjList;
	static int answer;
	static int y;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n+1];
		visited = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList[u].add(v);
			adjList[v].add(u);
		}

		answer = -1;
		visited[x] = true;
		dfs(x, 0);
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	
	static void dfs(int now, int count) {
		if(now == y) {
			answer = count;
			return;
		}
		
		for (int i = 0; i < adjList[now].size(); i++) {
			int next = adjList[now].get(i);
			
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, count+1);
			}
		}
	}
}