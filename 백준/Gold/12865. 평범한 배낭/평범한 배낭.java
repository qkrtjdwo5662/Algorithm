import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int k;
	static int[] dp;
	
	static class Good{
		int weight;
		int value;
		
		public Good(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	static Good goods[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		goods = new Good[n];
		dp = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			
			Good good = new Good(weight, value);
			goods[i] = good;
		}
		
		for (int i = 0; i < n; i++) {
			Good now = goods[i];
			
			for (int j = k; j >= now.weight; j--) {
				dp[j] = Math.max(dp[j], dp[j - now.weight] + now.value);
			}
			
//			System.out.print(Arrays.toString(dp));
		}
		
		sb.append(dp[k]).append("\n");
//		System.out.print(Arrays.toString(dp));
		System.out.println(sb);
		
	}
}