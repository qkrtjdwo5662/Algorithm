import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger[][] dp = new BigInteger[n + 1][n + 1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if(i == j || j == 0) {
					dp[i][j] = new BigInteger("1");
				}else {
					dp[i][j] = dp[i-1][j].add(dp[i-1][j-1]);
				}
			}
		}
		
		System.out.println(dp[n][m]);
		
	}
}