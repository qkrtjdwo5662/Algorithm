import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static StringBuilder sb;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		
	
		devide(0, 0, n);
		
		System.out.println(sb);
	}
	
	static void devide(int startY, int startX, int n) {
		if(n == 0) return;
		
		boolean check = true;
		int num = board[startY][startX];
		
		loop:
		for (int i = startY; i < startY + n; i++) {
			for (int j = startX; j < startX + n; j++) {
				if(board[i][j] != num) {
					check = false;
					break loop;
				}
			}
		}
		
		n = n/2;
		if(check) {
			sb.append(num);
		}else {
			sb.append("(");
			
			devide(startY, startX, n);
			devide(startY, startX + n, n);
			devide(startY + n, startX, n);
			devide(startY + n, startX + n, n);
			
			sb.append(")");
		}
	
	}
}