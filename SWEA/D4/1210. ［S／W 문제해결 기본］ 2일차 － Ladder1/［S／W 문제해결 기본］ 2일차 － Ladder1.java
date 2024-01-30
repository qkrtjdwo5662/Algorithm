import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	public static int[] ry = { 0, 0, -1, 0 };
	public static int[] rx = { 1, -1, 0, 0 };
	public static final int MAX = 100;
	public static int answer;
	public static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			board = new int[MAX][MAX];

			int[] start = null;
			for (int i = 0; i < MAX; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < MAX; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
					
					if(num == 2) {
						start = new int[] {i, j};
					}
				}
			}
			boolean[][] visited = new boolean[MAX][MAX];
			answer = -1;
			run(start, visited);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}

	public static void run(int[] now,  boolean[][] visited) {
		if(now[0] == 0) {
			answer = now[1];
			return;
		}
		
		// 좌우 판단
		for (int i = 0; i < 3; i++) {
			int r = now[0] + ry[i];
			int c = now[1] + rx[i];
				
			if(r < 0 || c<0 || r>= MAX || c>= MAX) continue;
			
			if(board[r][c] == 0) continue;
			
			if(!visited[r][c]) {
				visited[r][c] = true;
				run(new int[] {r, c}, visited);
				break;
			}
		}
		
	}
}