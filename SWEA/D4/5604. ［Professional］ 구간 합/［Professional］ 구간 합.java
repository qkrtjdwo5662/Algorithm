import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			
			dp = new long[17];
			
			dp[1] = 45;
			for (int i = 2; i < dp.length; i++) {
				dp[i] = (long) ((dp[i -1] * 10) + (45 * Math.pow(10, i - 1)));
			}
			
			long answer = sum(b) - sum(a-1);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	static long sum(long num) {
		if(num < 10) {
			long sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			
			return sum;
		}
		
		int len = String.valueOf(num).length();
		int frontNum = (int) (num / (Math.pow(10, len - 1)));
		
		long sum = dp[len - 1] * frontNum;
		
		for (int i = 1; i < frontNum; i++) {
			sum += i * Math.pow(10, len - 1);
		}
		
		long temp = (long) (num - (frontNum * Math.pow(10, len - 1)));
		
		return (long) (sum + frontNum * (temp + 1) + sum(temp));
		
	}
	
}
