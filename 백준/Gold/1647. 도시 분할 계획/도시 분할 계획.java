import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static int[] parents;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n + 1];
		
		
		
		
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
		edgeList = new Edge[m];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			Edge edge = new Edge(start, end, weight);
			edgeList[i] = edge;
		}
		
		
		Arrays.sort(edgeList, (o1, o2) -> {
			return Integer.compare(o1.weight, o2.weight);
		});
		
		int answer = 0;
		int count = 0;
		
		for (int i = 0; i < m; i++) {
			Edge now = edgeList[i];
			int start = now.start;
			int end = now.end;
			int weight = now.weight;
			
			if(union(start, end)) {
				answer += weight;
				count ++;
			}
			
			if(count == n-2) break;
		}
		if(n == 2) {
			sb.append(0).append("\n");
		}else {
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x == y) return false;
		else {
			parents[x] = y;
			return true;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return parents[a];
		return parents[a] = find(parents[a]);
	}
}