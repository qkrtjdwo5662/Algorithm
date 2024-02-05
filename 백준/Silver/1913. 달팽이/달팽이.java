import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] answer = null;
	static int target;
	static int[][] board;
	static int n;
	
	static int[] rx = {0, 1, 0, -1};
	static int[] ry = {1, 0, -1, 0};
	
	static int[] pos;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		
		board[0][0] = n*n;
		
		int[] start = {0, 0};
		pos = null;
		dfs(1, n*n, start, 0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(board[i][j]).append(" ");
				if(board[i][j] == target) {
					pos = new int[] {i+1, j+1};
				}
			}
			sb.append("\n");
		}		
	
		sb.append(pos[0]).append(" ").append(pos[1]).append("\n");
		System.out.println(sb);
		
	}
	
	public static void dfs(int count, int num,  int[] now, int d) {
		if(count == board[0][0]) {
			return;
		}
		
		
		for (int i = 0; i < 4; i++) {
			int r = now[0] + ry[(d+i)%4];
			int c = now[1] + rx[(d+i)%4];
			
			if(r<0 || c<0 || r>= n || c>= n) continue;
			
			if(board[r][c] == 0) {
				board[r][c] = num - count;
				dfs(count+1, num, new int[] {r,c}, (d+i)%4);
				break;
			}
		}
	}
}