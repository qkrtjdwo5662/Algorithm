import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
*/
public class Main {
	static int n;
	static int m;
	
	static char[][] board;
	
	static int[] ry = {1, -1, 0, 0};
	static int[] rx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j] == 'L') {
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}
		
//		bfs(0, 1);
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	
	static int bfs(int y, int x) {
		boolean[][] visited = new boolean[n][m];
		
		int[][] dist = new int[n][m];
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] {y, x});
		visited[y][x] = true;
		
		int size = 0;
		int depth = 0;
		while(!deque.isEmpty()) {
			depth ++;
			size = deque.size();
			for (int i = 0; i < size; i++) {
				int[] now = deque.pollFirst();
				
				for (int j = 0; j < 4; j++) {
					int r = now[0] + ry[j];
					int c = now[1] + rx[j];
					
					if(r < 0 || c < 0 || r>= n || c>= m ) continue;
					
					if(board[r][c] != 'L' ) continue;
					
					if(!visited[r][c]) {
						visited[r][c] = true;
						deque.addLast(new int[] {r, c});
						dist[r][c] = dist[now[0]][now[1]] + 1;
					}
				}		
			}
			
			
		}
		
		return depth - 1;
	}
}