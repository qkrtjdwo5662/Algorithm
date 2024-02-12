import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int l;
	static int[][] arr;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			arr = new int[n][2];
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				
				arr[j][0] = score;
				arr[j][1] = calorie;
				
			}
			answer =0;
			dfs(0, 0, 0);
			
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth, int nowScore, int nowCal) {
		if(nowCal > l) return;
		
		if(depth == n) {
			answer = Math.max(answer, nowScore);
			
			return;
		}
		
		
		dfs(depth + 1, nowScore, nowCal);
		dfs(depth + 1, nowScore + arr[depth][0], nowCal + arr[depth][1]);
	}
}