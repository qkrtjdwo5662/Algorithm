import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static ArrayList<Integer>[] adjList;
	static int[] count;
	static ArrayDeque<Integer> deque;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[n+1]; 
		count = new int[n+1];
		deque = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			count[v] ++;
		}
		
		for (int i = 1; i <= n; i++) {
			if(count[i] == 0) deque.addLast(i);
		}
		
		sorted();
		System.out.println(sb);
	}
	static void sorted() {
		while(!deque.isEmpty()) {
			int now = deque.pollFirst();
			
			sb.append(now).append(" ");
			for (int i = 0; i < adjList[now].size(); i++) {
				int next = adjList[now].get(i);
				
				count[next]--;
				
				if(count[next] == 0) {
					deque.addLast(next);
				}
			}
		}
	}
	
	
}