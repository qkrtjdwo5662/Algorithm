import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	
	static int[][] belt;
	
	static int[] rx = {1, 0, -1, 0};
	static int[] ry = {0, 1, 0, -1};
	
	static class Robot{
		int y;
		int x;
		public Robot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static ArrayList<Robot> robotList;
	static int[][] robotBoard;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		belt = new int[2][n];
		robotBoard = new int[2][n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			belt[0][i] = num;
		}
		
		for (int i = n-1; i >= 0; i--) {
			int num = Integer.parseInt(st.nextToken());
			belt[1][i] = num;
		}
		
		robotList = new ArrayList<>();
		
		int answer = 0;
		
		while(true) {
			answer ++;
			
			rotate(0, 1, 0, 0, belt[0][0]);
			rotateRobot();
			robotMove();
			
			if(belt[0][0] != 0) {
				belt[0][0] --;
				Robot robot = new Robot(0,  0);
				robotList.add(robot);
			}
			if(beltCount() >= k) break;
			
		}
		
		sb.append(answer).append("\n");
		System.out.println(sb);
		
		
		
	}
	static void rotateRobot() {
		for (int i = 0; i < robotList.size(); i++) {
			Robot now = robotList.get(i);
			
			int r = now.y + ry[0];
			int c = now.x + rx[0];
			
			now.y = r;
			now.x = c;
			
			if(now.x == n-1) {
				robotList.remove(i);
				i--;
			}
			
		}
	}
	
	static void robotMove() {
		loop:
		for (int i = 0; i < robotList.size(); i++) {
			Robot now = robotList.get(i);
			
			int r = now.y + ry[0];
			int c = now.x + rx[0];
			
			for (int j = 0; j < i; j++) {
				Robot robot = robotList.get(j);
				
				if(r == robot.y && c == robot.x) {
					continue loop;
				}
				
			}
			
			if(belt[r][c] == 0) continue;
			
			now.y = r;
			now.x = c;
			
			belt[r][c] --;
			if(now.x == n-1) {
				robotList.remove(i);
				i--;
			}
			
		}
		
	}
	
	static void rotate(int y, int x, int depth, int d, int value) {
		if(depth == 2 * n) {
			return;
		}
		
		
		int temp = belt[y][x];
		belt[y][x] = value;
		
		for (int i = d; i < d + 4; i++) {
			int r = y + ry[i%4];
			int c = x + rx[i%4];
			
			if(r < 0 || c < 0 || r>= 2 || c>= n) continue;
			
			rotate(r, c, depth + 1, i, temp);
			break;
		}
		
	}
	
	static void print() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(belt[i][j] + " ");
			}
			
			System.out.println();
		}
		System.out.println();
	}
	
	static int beltCount() {
		int count = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				if(belt[i][j] == 0) count++;
			}
		}
		
		return count;
	}
	
}