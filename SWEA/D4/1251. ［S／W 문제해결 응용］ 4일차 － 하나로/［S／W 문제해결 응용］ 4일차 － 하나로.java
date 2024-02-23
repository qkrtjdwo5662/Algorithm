import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static class Node{
		int x;
		int y;
	}
	
	static class Edge{
		int start;
		int end;
		double cost;
		
		public Edge(int start, int end, double cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	static Node[] nodeList;
	static ArrayList<Edge> edgeList;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			nodeList = new Node[n];
			parents = new int[n];
			
			
			for (int j = 0; j < n; j++) {
				Node node = new Node();
				nodeList[j] = node;
				parents[j] = j;
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				int x = Integer.parseInt(st.nextToken());
				nodeList[j].x = x;
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				int y = Integer.parseInt(st.nextToken());
				nodeList[j].y = y;
			}
			
			st = new StringTokenizer(br.readLine());
			double e = Double.parseDouble(st.nextToken());
			
			edgeList = new ArrayList<>();
			
			for (int j = 0; j < n-1; j++) {
				Node node1 = nodeList[j];
				for (int k = j + 1; k < n; k++) {
					Node node2 = nodeList[k];
					
					double d = Math.pow(Math.abs(node1.x - node2.x), 2) +  Math.pow(Math.abs(node1.y - node2.y), 2);
					double cost = d*e;
					Edge edge = new Edge(j, k, cost);
					edgeList.add(edge);
				}
			}
			
			
			Collections.sort(edgeList, (o1, o2) -> {
				return Double.compare(o1.cost, o2.cost);
			});
			
			double costSum = 0;
			
			for (int j = 0; j < edgeList.size(); j++) {
				Edge now = edgeList.get(j);
				
				int start = now.start;
				int end = now.end;
				double cost = now.cost;
				
				if(union(start, end)) {
					costSum += cost;
				}
			}
			sb.append("#").append(i).append(" ").append(String.format("%.0f",costSum )).append("\n");
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