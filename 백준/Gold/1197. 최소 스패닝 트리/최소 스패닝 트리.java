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
		
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		parents = new int[v + 1];
		
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
		
		edgeList = new Edge[e];
		
		for (int i = 0; i< e; i++) {
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
		
		long answer = 0;
		int count = 0;
		for (int i = 0; i < e; i++) {
			Edge edge = edgeList[i];
			
			int start = edge.start;
			int end = edge.end;
			int weight = edge.weight;
			
			if(union(start, end)) {
				answer += weight;
				count++;
			}
			
			if(count == v-1) break;
		}
		sb.append(answer).append("\n");
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