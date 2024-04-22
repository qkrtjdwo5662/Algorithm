import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 10_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;
		
		for(int i = 4; i<= n; i++) {
			dp[i] = (dp[i - 1] + 2*dp[i - 2]) % MOD;
		}
		
		System.out.println(dp[n]);
		
	}
}