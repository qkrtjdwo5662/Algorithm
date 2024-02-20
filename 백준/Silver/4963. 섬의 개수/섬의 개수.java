import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static int[][] board;
	static boolean[][] visited;
	
	static int[] ry = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] rx = {1, -1, 0, 0, -1, 1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			board = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
				}
			}
			visited = new boolean[h][w];
			int answer = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && board[i][j] == 1) {
						bfs(new int[] {i, j});
						answer++;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int[] start) {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.addLast(start);
		visited[start[0]][start[1]] = true;
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			for (int i = 0; i < 8; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c<0 || r>= h || c>= w) continue;
				
				if(board[r][c] != 1) continue;
				
				if(!visited[r][c]) {
					visited[r][c] = true;
					deque.addLast(new int[] {r,c});
				}
			}
		}
		
		
	}
}