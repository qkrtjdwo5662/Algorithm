import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[n+1][n+1];
			
			for (int j = 1; j <=  n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					int num = Integer.parseInt(st.nextToken());
					board[j][k] = num;
					board[j][k] += board[j-1][k];
					board[j][k] += board[j][k-1];
					board[j][k] -= board[j-1][k-1];
				}
			}
			
			int max = 0;
			
			for (int j = 0; j <= n-m; j++) {
				for (int k = 0; k <= n-m; k++) {
					int kill = 0;
					kill = board[j+m][k+m];
					kill -= board[j][k+m];
					kill -= board[j+m][k];
					kill += board[j][k];
					
					max= Math.max(kill, max);
				}
			}
			
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		
	}
}