import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final int MOD = 1_234_567_891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			long[] factor = new long[n + 1];
			factor[1] = 1;
			for (int i = 2; i <= n; i++) {
				factor[i] = (factor[i - 1] * i) % MOD;
			}
			
			long bottom = (factor[r] * factor[n - r]) % MOD;
			bottom = pow(bottom , MOD - 2);
			
			sb.append("#").append(t).append(" ").append((factor[n] * bottom) % MOD).append("\n");
		}
		System.out.println(sb);
	}
	
	static long pow(long a, int b) {
		if(b == 0) return 1;
		else if(b == 1) return a;
		if(b % 2== 0) {
			long tmp = pow(a, b/2);
			return (tmp * tmp) % MOD;
			
		}
		
		long tmp = pow(a, b-1) % MOD;
		return (tmp * a) % MOD;
	}
}