import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[m + 1][m + 1];
			
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= i; j++) {
					if(j == 0 || j == i) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
						
					}
				}
			}
			
			sb.append(dp[m][n]).append("\n");
			
		}
		System.out.println(sb);
	}
}