import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] count;
	static ArrayList<Integer>[] adjList;
	static PriorityQueue<Integer> pq;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[n+1];
		count = new int[n+1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		pq =new PriorityQueue<>();
		
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			count[v] ++;
		}
		
	
		
		for (int i = 1; i <= n; i++) {
			if(count[i] == 0) {
				pq.add(i);
			}
		}
		bfs();
		System.out.println(sb);
	}
	
	static void bfs() {
	
		while(!pq.isEmpty()) {
			int now = pq.poll();
			
			sb.append(now).append(" ");
			
			for (int i = 0; i < adjList[now].size(); i++) {
				int next = adjList[now].get(i);
				count[next] --;
				
				if(count[next] == 0) {
					pq.add(next);
				}
			}
		}
	}
	
}