import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		dp = new long[101];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= 100; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}
		
		
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(dp[n]).append("\n");
			
		}
		
		System.out.println(sb);
	}
}