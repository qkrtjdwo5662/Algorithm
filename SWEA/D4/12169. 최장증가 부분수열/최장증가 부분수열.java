import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			int[] dp = new int[n + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				
				for (int j = 0; j < i; j++) {
					if(arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
			
			int max = 0;
			for (int i = 0; i <= n; i++) {
				max = Math.max(max, dp[i]);
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		
	}
}