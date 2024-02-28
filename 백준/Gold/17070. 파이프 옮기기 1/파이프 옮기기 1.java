import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int n;
	static int[][] board;
	static int count;
	static boolean[][] visited;
	static int[] ry = {0, 1, 1};
	static int[] rx = {1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				
				int num = Integer.parseInt(st.nextToken());
				if(num != 0) {
					board[i][j] = num;
				}
			}
		}
		// 0 빈칸 // 1 벽
		
		count = 0;
		visited = new boolean[n][n];
		
		visited[0][0] = true;
		visited[0][1] = true;
		
		go(new int[] {0, 1}, 0);
		System.out.println(count);
	}
	
	static void go(int[] now, int d) {
		if(now[0] == n-1 && now[1] == n-1) {
			count ++;
			return;
		}
		
		if(d == 0) {
			// 가로면
			// 가로 혹은 대각선
			int flag = 0;
			for (int i = 0; i < 2; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c < 0 || r>= n || c>= n ) continue;
				
				if(board[r][c] == 1) continue;
				
				flag ++;
				
				if(i == 1) continue;
			
				go(new int[] {r, c}, 0);
			}
			
			if(flag == 2) {
				int r = now[0] + ry[2];
				int c = now[1] + rx[2];
				
				if(board[r][c] != 1 ) {
					go(new int[] {r, c}, 2);
				}
			}
			
		}else if(d == 1) {
			// 세로면
			// 세로 혹은 대각선
			
			int flag = 0;
			for (int i = 0; i < 2; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c < 0 || r>= n || c>= n ) continue;
				
				if(board[r][c] == 1) continue;
				
				flag ++;
				
				if(i == 0) continue;
			
				go(new int[] {r, c}, 1);
			}
			
			if(flag == 2) {
				int r = now[0] + ry[2];
				int c = now[1] + rx[2];
				
				if(board[r][c] != 1 ) {
					go(new int[] {r, c}, 2);
				}
			}
			
		}else if(d == 2) {
			// 대각선이면
			// 가로 혹은 세로 혹은 대각선
			int flag = 0;
			for (int i = 0; i < 2; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c < 0 || r>= n || c>= n ) continue;
				
				if(board[r][c] == 1) continue;
				
				flag ++;
			
				go(new int[] {r, c}, i);
			}
			
			if(flag == 2) {
				int r = now[0] + ry[2];
				int c = now[1] + rx[2];
				
				if(board[r][c] != 1 ) {
					go(new int[] {r, c}, 2);
				}
			}
		}
	}
}