import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] ry = {-1, 0, 1, 0};
	static int[] rx = {0, -1, 0, 1};
	static int[] pos;
	static int d;
	static char[][] board;
	static int n;
	static int m;
	 public static void main(String[] args) throws IOException {
		 //. 평지
		 //* 벽돌 벽
		 //# 강철 벽
		 //- 물
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 StringBuilder sb = new StringBuilder();
		 
		 int tc = Integer.parseInt(st.nextToken());
		 
		 for (int i = 1; i <= tc; i++) {
			sb.append("#").append(i).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			board = new char[n][m];
			pos = null;
			d = -1;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				for (int k = 0; k < m; k++) {
					char c = s.charAt(k);
					board[j][k] = c;
					
					if(c == '^' || c == 'v' || c== '<' || c== '>') {
						pos = new int[] {j, k};
						if(c ==  '^') {
							d = 0;
						}else if(c == 'v') {
							d = 2;
						}else if(c == '<') {
							d = 1;
						}else if(c == '>') {
							d = 3;
						}
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String opr = st.nextToken();
			run(opr);
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					sb.append(board[j][k]);
				}
				sb.append("\n");
			}
			
		 }
		 System.out.println(sb);
	}
	static boolean goCheck(int y, int x) {
		if(y < 0 || x < 0 || y>= n || x>= m) return false;
		
		if(board[y][x] != '.') return false;
		
		return true;
	}
	
	static void move(int y1, int x1, int y2, int x2) {
		board[y1][x1] = '.';
		
		if(d == 0) {
			board[y2][x2] = '^';
		}else if(d == 1) {
			board[y2][x2] = '<' ;
		}else if(d == 2) {
			board[y2][x2] = 'v';
		}else if(d == 3) {
			board[y2][x2] = '>';
		}
		 
	}
	
	static void noMove(int y, int x) {
		if(d == 0) {
			board[y][x] = '^';
		}else if(d == 1) {
			board[y][x] = '<' ;
		}else if(d == 2) {
			board[y][x] = 'v';
		}else if(d == 3) {
			board[y][x] = '>';
		}
	}
	
	static void run(String opr) {
		for (int i = 0; i < opr.length(); i++) {
			char ch = opr.charAt(i);
			
			int r = -1;
			int c=  -1;
			
			if(ch == 'U') {
				d = 0;
				r = pos[0] + ry[d];
				c = pos[1] + rx[d];
				if(goCheck(r, c)) {
					move(pos[0], pos[1], r, c);
					pos[0] = r;
					pos[1] = c;
				}else noMove(pos[0], pos[1]);
				
			}else if(ch == 'D') {
				d = 2;
				r = pos[0] + ry[d];
				c = pos[1] + rx[d];
				if(goCheck(r, c)) {
					move(pos[0], pos[1], r, c);
					pos[0] = r;
					pos[1] = c;
				}else noMove(pos[0], pos[1]);
			}else if(ch == 'L') {
				d = 1;
				r = pos[0] + ry[d];
				c = pos[1] + rx[d];
				if(goCheck(r, c)) {
					move(pos[0], pos[1], r, c);
					pos[0] = r;
					pos[1] = c;
				}else noMove(pos[0], pos[1]);
			}else if(ch == 'R') {
				d = 3;
				r = pos[0] + ry[d];
				c = pos[1] + rx[d];
				if(goCheck(r, c)) {
					move(pos[0], pos[1], r, c);
					pos[0] = r;
					pos[1] = c;
				}else noMove(pos[0], pos[1]);
			}else if(ch == 'S') {
				shoot();
			}
		}
	}
	
	static void shoot() {
		int ny = pos[0];
		int nx = pos[1];
		
		while(true) {
			int r = ny + ry[d];
			int c = nx + rx[d];
			
			if(r < 0 || c< 0 || r>=n || c>= m) break;
			
			if(board[r][c] == '#') break;
			
			if(board[r][c] == '*') {
				board[r][c] = '.';
				break;
			}
			ny = r;
			nx = c;
		}
	}
}