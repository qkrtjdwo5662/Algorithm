import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int answer;
	static int[] arr;
	static boolean[] visited;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			visited = new boolean[n];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num;
			}
			
			answer = 0;
			dfs(0, 0);
			if(answer == 0) sb.append("#").append(i).append(" ").append(-1).append("\n");
			else sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int count, int now) {
		if(now > m) return;
		
		if(count == 2) {
			answer = Math.max(answer, now);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(count+1, arr[i] + now);
				visited[i] = false;
			}
		}
	}
}