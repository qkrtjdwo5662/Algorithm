import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int REMAIM = 10_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) dp[i][j] = 1;
				else {
					dp[i][j] = (dp[i-1][j-1] % REMAIM + dp[i-1][j] % REMAIM)%REMAIM ;
				}
				
			}
		}
		
		sb.append(dp[n][k]).append("\n");
		System.out.println(sb);
	}
}