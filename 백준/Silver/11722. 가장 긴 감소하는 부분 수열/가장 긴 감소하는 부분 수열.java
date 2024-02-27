import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		int[] dp = new int[n + 1];
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			
			int num1 = arr[i];
			
			
			for (int j = 1; j < i; j++) {
				int num2 = arr[j];
				
				if(num2 > num1) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		sb.append(max).append("\n");
		System.out.println(sb);
		
		
	}
}