import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] ry = {0, 1, 0, -1};
	static int[] rx = {1, 0, -1, 0};
	static int[][] board;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			sb.append("#").append(i).append("\n");
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			
			board = new int[n][n];
			board[0][0] = 1;
			run(2,n*n, 0, new int[] {0,0});
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					sb.append(board[j][k]).append(" ");
				}
				sb.append("\n");
			}
		}	
		System.out.println(sb);
	}
	
	public static void run(int count, int m, int d, int[] now) {
		if(count > m) return;
		
		for (int i = 0; i < 4; i++) {
			int r = now[0] + ry[(d + i) % 4];
			int c = now[1] + rx[(d + i) % 4];
			
			if(r < 0 || c< 0 || r>= n || c>= n) continue;
			
			if(board[r][c] == 0) {
				board[r][c] = count;
				run(count+1, m, (d+i)%4, new int[] {r, c});
				break;
			}
		}
		
		
		
		
	}
}