import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge{
		int start;
		int end;
		int cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	static int[] parents;
	static Edge[] edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			Edge edge = new Edge(u, v, w);
			edgeList[i] = edge;
		}
		
		Arrays.sort(edgeList, (o1, o2) -> {
			return Integer.compare(o1.cost, o2.cost);
		});
		
		int answer = 0;
		int count = 0;
		for (int i = 0; i < m; i++) {
			Edge now = edgeList[i];
			
			if(union(now.start, now.end)) {
				answer += now.cost;
				count ++;
			}
			
			if(count == n-1) break;
		}
		
		sb.append(answer).append("\n");
		System.out.println(sb);
		
	}
	
	static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x == y) {
			return false;
		}else {
			parents[x] = y;
			return true;
		}
		
	}
	
	static int find(int a) {
		if(parents[a] == a) return parents[a];
		return parents[a] = find(parents[a]);
	}
}