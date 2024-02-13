import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Goods{
		int weight;
		int value;
		
		public Goods(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][k+1];
		Goods[] goodsArr = new Goods[n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			goodsArr[i] = new Goods(w, v);
		}
		
		for (int i = 1; i <= n; i++) {
			Goods goods = goodsArr[i];
			
			for (int j = 1; j <= k; j++) {
				dp[i][j] = dp[i-1][j];
				
				if(j >= goods.weight) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j - goods.weight] + goods.value);
				}	
				
			}
		}
		
		sb.append(dp[n][k]).append("\n");
		System.out.println(sb);
		
	}
}