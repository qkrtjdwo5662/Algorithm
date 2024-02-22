import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static class Leaf{
		int depth;
		int value;
		
		public Leaf(int depth, int value) {
			this.depth = depth;
			this.value = value;
		}
	}
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Leaf> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = 10;
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			adjList= new ArrayList[101];
			list = new ArrayList<>();
			for (int j = 1; j <= 100; j++) {
				adjList[j] = new ArrayList<>();
			}
			
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < length/2; j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from].add(to);
			}

			visited = new boolean[101];
			bfs(start);
			
			Collections.sort(list, (o1, o2) -> {
				if(o1.depth == o2.depth) {
					return Integer.compare(o1.value, o2.value);
				}else {
					return Integer.compare(o1.depth, o2.depth);
				}
			});
			sb.append("#").append(i).append(" ").append(list.get(list.size() -1).value).append("\n");
		}
		System.out.println(sb);
	}
	
	
	static void bfs(int start) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		deque.addLast(start);
		visited[start] = true;
		
		int size = 0;
		int depth = 0;
		
		while(!deque.isEmpty()) {
			depth++;
			size = deque.size();
			for (int i = 0; i < size; i++) {
				int now = deque.pollFirst();
				
				boolean flag = false;
				
				for (int j = 0; j < adjList[now].size(); j++) {
					int next= adjList[now].get(j);
					
					if(!visited[next]) {
						visited[next] = true;
						deque.addLast(next);
						flag = true;
					}
				}
				
				if(!flag) {
					list.add(new Leaf(depth, now));
				}
			}
		}
	}
	
}