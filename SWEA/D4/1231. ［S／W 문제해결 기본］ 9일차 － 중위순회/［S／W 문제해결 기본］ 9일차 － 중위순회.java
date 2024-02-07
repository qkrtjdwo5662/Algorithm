import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb;
	static String[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int tc = 10;
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new String[n + 1];
			
			for (int j = 1; j <= n; j++) {
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				String s = st.nextToken();
				st.hasMoreTokens();
				arr[j] = s;
			} 
			sb.append("#").append(i).append(" ");
			preOrder(1);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void preOrder(int now) {
		if(now*2 <= n) {
			preOrder(now*2);
		}
		
		sb.append(arr[now]);
		
		if(now*2 +1 <= n) {
			preOrder(now*2 + 1);
		}
	}
	
}