import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Good{
		int weight;
		int value;
		
		public Good(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
		
	}
	
	static int n;
	static int k;
	static int[][] dp;
	static Good[] goods;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new int[n + 1][k + 1];
		
		goods = new Good[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			Good good = new Good(weight, value);
			goods[i] = good;
		}
		
		
		for (int i = 1; i <= n; i++) {
			Good now = goods[i-1];
			
			for (int j = 0; j <= k; j++) {
				dp[i][j] = dp[i-1][j];
				
				if(j>= now.weight) {
					dp[i][j] = Math.max(dp[i-1][j-now.weight] + now.value, dp[i][j]);
				}
			}
		}
		
		sb.append(dp[n][k]).append("\n");
		System.out.println(sb);
		
	}
}