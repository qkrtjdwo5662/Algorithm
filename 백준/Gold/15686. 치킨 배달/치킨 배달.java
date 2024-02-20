import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] board;
	
	static ArrayList<int[]> houseList;
	static ArrayList<int[]> chickenList;
	
	static boolean[] visited;
	
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 0 : 빈칸
		// 1 : 집
		// 2 : 치킨집
		
		board = new int[n][n];
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				
				if(num == 1) {
					houseList.add(new int[] {i, j});
				}
				
				if(num == 2) {
					chickenList.add(new int[] {i, j});
				}
			}
		}
		visited = new boolean[chickenList.size()];
		answer = 987654321;
		selectChicken(0, 0);
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	static int chickenDistance() {
		int total = 0;
		
		for (int i = 0; i < houseList.size(); i++) {
			int min = 987654321;
			int[] house = houseList.get(i);
			int d = 0; 
			for (int j = 0; j < chickenList.size(); j++) {
				if(visited[j]) {
					int[] chicken = chickenList.get(j);
					
					d = Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]); 
					min = Math.min(min, d);
				}
			}
			
			total += min;
			
			
		}
		
		
		return total;
	}
	
	static void selectChicken(int depth, int index) {
		if(depth == m) {
			answer = Math.min(answer, chickenDistance());
			return;
		}
		
		
		for (int i = index; i < visited.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selectChicken(depth + 1, i);
				visited[i] = false;
			}
		}
	}
}