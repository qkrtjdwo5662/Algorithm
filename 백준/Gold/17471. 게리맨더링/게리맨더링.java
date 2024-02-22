import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] weights;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static boolean flag;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		weights = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			weights[i] = num;
		}
		
		adjList = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		flag = false;
		answer = 987654321;
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < size; j++) {
				int num = Integer.parseInt(st.nextToken());
				adjList[i].add(num);
			}
		}
		
		backtrack(1, 0);
		
		if(!flag) sb.append(-1).append("\n");
		else sb.append(answer).append("\n");
		
		System.out.println(sb);
	}
	static void backtrack(int depth, int count) {
		if(depth == n + 1) {
			//조합 선정 완료
			if(count != 0 && count != n) {
				if(check()) {
					answer = Math.min(answer, getMinDiff());
					flag = true;
				}
			}
			return;
		}
		
		visited[depth] = true;
		backtrack(depth + 1, count + 1);
		visited[depth] = false;
		backtrack(depth + 1, count);
	}
	
	static int getMinDiff() {
		int firstSum = 0;
		int secondSum = 0;
		
		for (int i = 1; i <= n; i++) {
			if(visited[i]) {
				firstSum += weights[i];
			}else {
				secondSum += weights[i];
			}
		}
		
		
		return Math.abs(firstSum - secondSum);
	}
	
	static boolean check() {
		int first = 0;
		int second = 0;
		
		int firstCount = 0;
		int secondCount = 0;
		
		boolean[] used = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if(visited[i]) {
				first = i;
			}else second = i;
			
			if(first != 0 && second != 0) break;
		}
		
		for (int i = 1; i <= n; i++) {
			if(visited[i]) {
				firstCount++;
			}else secondCount ++;
		}

		
		
		if(!bfs(first, used, firstCount, 0)) {
			return false;
		}
		
		if(!bfs(second, used, secondCount, 1)) {
			return false;
		}
		
		for (int i = 1; i <= n; i++) {
			if(!used[i]) return false;
		}
		
		return true;
	}
	
	static boolean bfs(int start, boolean[] used, int num, int opr) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.addLast(start);
		
		used[start] = true;
		int count = 0;
		
		while(!deque.isEmpty()) {
			int now = deque.pollFirst();
			count ++;
			for (int i = 0; i < adjList[now].size(); i++) {
				int next = adjList[now].get(i);
				
				if(opr == 0) {
					if(!visited[next]) continue;
				}else if(opr == 1) {
					if(visited[next]) continue;
				}
				
				if(!used[next]) {
					used[next] = true;
					deque.addLast(next);
				}
			}
		}
		
		if(count != num) {
			return false;
		}
		return true;
		
	}
}