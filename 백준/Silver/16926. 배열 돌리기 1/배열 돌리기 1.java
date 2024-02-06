import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] board;
	static boolean[][] visited;
	static int[] ry = {1, 0, -1, 0};
	static int[] rx = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
			}
		}
		int count = 0;
		
		while(count < r) {
			int index = 0;
			visited = new boolean[n][m];
			while(!visited[index][index]) {
				rotate(new int[] {index, index}, 0, board[index][index + 1]);
				index ++;
			}
			count++;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
		
		
	}
	
	static void rotate(int[] now, int d, int t) {
		int temp = board[now[0]][now[1]];
		board[now[0]][now[1]] = t;
		
		for (int i = 0; i < 4; i++) {
			int r = now[0] + ry[(d+i)%4];
			int c = now[1] + rx[(d+i)%4];
			
			if(r<0 || c<0 || r>= n || c>= m) continue;
			
			if(!visited[r][c]) {
				visited[r][c] = true;
				rotate(new int[] {r, c}, (d+i)%4, temp);
				break;
			}
			
		}
		
	}
	
	
}