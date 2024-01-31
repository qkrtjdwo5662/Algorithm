import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n + 1][n + 1];
		int[][] sum = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=n; j++) {
				int num = Integer.parseInt(st.nextToken());
				sum[i][j] = num;
				sum[i][j] += sum[i-1][j];
				sum[i][j] += sum[i][j-1];
				sum[i][j] -= sum[i-1][j-1];
				
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int answer = sum[x2][y2]  + sum[x1-1][y1-1];
			answer -= sum[x1-1][y2];
			answer -= sum[x2][y1-1];
			sb.append(answer).append("\n");
		}
		
		
		
		System.out.println(sb);
	}
}