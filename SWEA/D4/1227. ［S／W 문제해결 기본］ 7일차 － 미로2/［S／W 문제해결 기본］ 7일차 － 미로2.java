import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	static final int size = 100;
	static int[][] board;
	static boolean[][] visited;
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			
			board = new int[size][size];
			visited = new boolean[size][size];
			int[] start = null;
			for (int i = 0; i < size; i++) {
				String s = br.readLine();
				for (int j = 0; j < size; j++) {
					int num = s.charAt(j) - '0';
					board[i][j] = num;
					
					if(num == 2) {
						start = new int[] {i, j};
					}
				}
			}
			
			if(bfs(start)) {
				sb.append("#").append(t).append(" ").append(1).append("\n");
			}else {
				sb.append("#").append(t).append(" ").append(0).append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
	static boolean bfs(int[] start) {
		visited[start[0]][start[1]] = true;
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.addLast(start);
		
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			if(board[now[0]][now[1]] == 3) {
				return true;
			}
			
			for (int i = 0; i < 4; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c < 0 || r>= size || c>= size) {
					continue;
				}
				
				if(board[r][c] == 1) continue;
				
				
				
				if(!visited[r][c]) {
					visited[r][c] = true;
					deque.addLast(new int[] {r,c});
				}
				
			}
		}
		
		return false;
		
	}
}