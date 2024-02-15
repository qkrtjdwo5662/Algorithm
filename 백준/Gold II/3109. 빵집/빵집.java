import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] board;
	static boolean[][] visited;
	
	static int answer;
	static int[] ry = {-1, 0, 1};
	static boolean check;
	static int[] rx = {1, 1,  1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		visited = new boolean[n][m];
		answer = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			check = false;
			dfs(i, 0);
		}
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	
	
	static void dfs(int nr, int nc) {
		if(check) return;
		
		if(visited[nr][nc]) {
			return;
		}
		
		visited[nr][nc] = true;
		
		
		if(nc == m-1) {
			answer++;
			check = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int r = nr + ry[i];
			int c = nc + rx[i];
			
			if(r < 0 || c < 0 || r>= n || c>= m) continue;
			
			if(board[r][c] == 'x') continue;
			
			if(!visited[r][c]) {
				dfs(r, c);
			}
		}
		
	}
}