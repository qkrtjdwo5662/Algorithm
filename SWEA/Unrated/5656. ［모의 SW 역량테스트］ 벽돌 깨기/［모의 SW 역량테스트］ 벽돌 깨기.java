import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int w;
	static int h;
	static int[][] board;
//	static ArrayList<int[]> topList;
//	static boolean[] shootVisited;
	
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
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
				}
			}
			
			// 슛 쏠 리스트 만들고
			// 슛쏘고
			// 벽돌 없애버리고
			answer = h*w;
			go(0, board);
			
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void go(int depth, int[][] board) {
		if(depth == n) {
			if(countBoard(board) < answer) {
				answer = countBoard(board);
//				print(board);
			}
			return;
		}
			
		
		ArrayList<int[]> topList = new ArrayList<>();
		settingShootList(board, topList);
		
		if(topList.size() == 0) {
			answer = 0;
			return;
		}
		
		for (int i = 0; i < topList.size(); i++) {
			int[] now = topList.get(i);
			int[][] newBoard = copyBoard(board);
			shoot(now[0], now[1], newBoard);
			int[][] downBoard = down(newBoard);
			go(depth + 1, downBoard);
			
			
		}
		
	}
	
	static int[][] down(int[][] board) {
		int[][] newBoard = new int[h][w];
		
		for (int i = 0; i < w; i++) {
			int index = h-1;
			for (int j = h-1; j >=0 ; j--) {
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
	
	static void shoot(int y, int x, int[][] board) {
		boolean[][] broken = new boolean[h][w];
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		
		broken[y][x] = true;
		deque.addLast(new int[] {y, x, board[y][x]});
		
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			int ny = now[0];
			int nx = now[1];
			int range = now[2];
			
			
			if(range == 1) { // 걍 뿌수기
				board[ny][nx] = 0;
				
			}else if(range >= 2) { // 범위 만큼 뿌수기
				
				board[ny][nx] = 0;
				
				for (int i = 0; i < 4; i++) {
					int r = ny + ry[i];
					int c = nx + rx[i];
					
					if(r < 0 || c< 0 || r >= h || c>= w) continue;
					
					if(!broken[r][c] && board[r][c] != 0) {
						broken[r][c] = true;
						int num = board[r][c];
						deque.addLast(new int[] {r, c, num});
					}
					
					for (int j = 0; j < range - 2; j++) {
						r += ry[i];
						c += rx[i];
						
						if(r < 0 || c< 0 || r >= h || c>= w) continue;
						
						if(!broken[r][c] && board[r][c] != 0) {
							broken[r][c] = true;
							int num = board[r][c];
							deque.addLast(new int[] {r, c, num});
							
						}
					}
				}
				
			}
			
		}
		
		
		
	}
	
	static void settingShootList(int[][] board, ArrayList<int[]> list) {
		loop:
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if(board[j][i] != 0) {
					list.add(new int[] {j, i});
					continue loop;
				}
			}
		}
	}
	
	
	static void print(int[][] board) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static int countBoard(int[][] board) {
		int answer = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(board[i][j] != 0) answer++;
			}
		}
		
		return answer;
	}
	
}