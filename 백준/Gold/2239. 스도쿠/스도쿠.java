import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static final int n = 9;
	
	static int[][] board;
	static boolean[] visited;
	
	static boolean flag;
	static ArrayList<int[]> zeroList;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		board = new int[n][n];
		visited = new boolean[n + 1];
		flag = false;
		zeroList = new ArrayList<>();
		
		// board 세팅
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j) - '0';
				
				if(board[i][j] == 0) zeroList.add(new int[] {i, j});
			}
		}
		backtrack22(0);
//		System.out.println(sb);
	}
	
	static void backtrack22(int depth) {
		if(flag) return;
		
		if(depth == zeroList.size()) {
			printBoard();
			System.out.println(sb);
			flag = true;
			return;
		}
		
		
		int[] now = zeroList.get(depth);
		
		int y = now[0];
		int x = now[1];
		
		
		for (int i = 1; i <= n; i++) {
			if(checkRowAndColumn(y, x, i) && checkSquare(y, x, i)) {
				board[y][x] = i;
				backtrack22(depth + 1);
				board[y][x] = 0;
			}
		}
		
	}
	
	
	static boolean checkRowAndColumn(int y, int x, int num) {
		for (int i = 0; i < n; i++) {
			if(board[y][i] == num ) return false;
			
			if(board[i][x] == num ) return false;

		}
		
		return true;
	}
	
	
	static boolean checkSquare(int y, int x, int num) {
		int startY = -1;
		int startX = -1;
		
		if( y >= 0 &&  y < 3) {
			startY = 0;
		}else if(y >=3 && y < 6) {
			startY = 3;
		}else if(y >= 6) {
			startY = 6;
		}
		
		if( x >= 0 &&  x < 3) {
			startX = 0;
		}else if(x >=3 && x < 6) {
			startX = 3;
		}else if(x >= 6) {
			startX = 6;
		}
		
		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if(board[i][j] == num) return false;
			}
		}
		
		
		return true;
	}
	
	static void printBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		
	}
}