import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int w;
	static int h;
	
	static int[][] board;
	
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			board = new int[h][w];
			answer = 987654321;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
				}
			}
			
			go(0, board);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	
	static void go(int depth, int[][] board) {
		if(depth ==  n) {
			answer = Math.min(answer, countBrick(board));
			return;
		}
		
		if(countBrick(board) == 0) {
			answer = 0;
			return;
		}
		
		
		for (int i = 0; i < w; i++) {
			int x = i;
			int y = select(i, board);
			
			if(y == -1) continue;
			
			int[][] newBoard = copyBoard(board);
			broke(y, x, newBoard);
			int[][] downBoard = downBoard(newBoard);
			
			go(depth +1, downBoard);
		}
	}
	
	static int countBrick(int[][] board) {
		int count = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(board[i][j] != 0) count ++;
			}
		}
		
		return count;
	}
	
	static int[][] downBoard(int[][] board){
		int[][] newBoard = new int[h][w];
		
		
		for (int i = 0; i < w; i++) {
			int index = h - 1;
			for (int j = h-1; j >= 0; j--) {
				if(board[j][i] != 0) {
					newBoard[index][i] = board[j][i];
					index --;
				}
			}
		}
		
		return newBoard;
	}
	
	static int[][] copyBoard(int[][] board){
		int[][] newBoard = new int[h][w];
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		
		return newBoard;
	}
	
	static void broke(int y, int x, int[][] board) {
		boolean[][] visited = new boolean[h][w];
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		
		visited[y][x] = true;
		deque.addLast(new int[] {y, x});
		
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollLast();
			
			int ny = now[0];
			int nx = now[1];
			
			if(board[ny][nx] == 1) {
				board[ny][nx] = 0;
			}else if(board[ny][nx] > 1) {
				
				for (int i = 0; i < 4; i++) {
					int r = ny + ry[i];
					int c = nx + rx[i];
					
					if( r< 0 || c< 0 || r>= h || c>= w) continue;
					
					if(board[r][c] != 0 && !visited[r][c]) {
						visited[r][c] = true;
						deque.addLast(new int[] {r, c});
					}
					
					for (int j = 0; j < board[ny][nx] - 2; j++) {
						r += ry[i];
						c += rx[i];
						
						if( r< 0 || c< 0 || r>= h || c>= w) continue;
						
						if(board[r][c] != 0 && !visited[r][c]) {
							visited[r][c] = true;
							deque.addLast(new int[] {r, c});
						}
					}
				}
				
				board[ny][nx] = 0;
			}
			
			
		}
		
	}
	
	static int select(int num, int[][] board) {
		
		for (int i = 0; i < h; i++) {
			if(board[i][num] != 0) {
				return i;
			}
		}
		
		return -1;
		
	}
}