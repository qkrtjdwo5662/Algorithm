import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int m;
	static int[][] board;
	
	static ArrayList<int[]> virusList;
	static ArrayList<int[]> blankList;
	
	static int all;
	static boolean[] visited;
	static int wallCount;
	static int[] ry = {0, 0, 1, -1};
	static int[] rx = {1, -1, 0, 0};
	
	static int answer;
	public static void main(String[] args) throws IOException {
		// 벽을 세개 뽑아서 설치하자.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		all = n*m;
		
		blankList = new ArrayList<>(); // 벽 리스트 
		virusList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) {
					blankList.add(new int[] {i, j});
				}else if(num == 1) {
					wallCount ++;
				}else if(num == 2) {
					virusList.add(new int[] {i, j});
				}
				board[i][j] = num;
			}
		}
		
		visited = new boolean[blankList.size()];
		answer = 0;
		comb(0, 0);
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	
	static void comb(int depth, int index) {
		if(depth == 3) {
			answer = Math.max(answer, bfs());
			return;
		}
		
		for (int i = index; i < visited.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int[] blank = blankList.get(i);
				board[blank[0]][blank[1]] = 1;
				comb(depth + 1, i);
				board[blank[0]][blank[1]] = 0;
				visited[i] = false;
			}
		}
	}
	
	static int bfs() {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		boolean[][] used = new boolean[n][m];
		
		int count =0;
		
		for (int i = 0; i < virusList.size(); i++) {
			int[] virus = virusList.get(i);
			count ++;
			deque.addLast(virus);
			used[virus[0]][virus[1]] = true;
		}
		
		while(!deque.isEmpty()) {
			int[] now = deque.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int r = now[0] + ry[i];
				int c = now[1] + rx[i];
				
				if(r < 0 || c < 0 || r>= n || c>= m) continue;
				
				if(board[r][c] == 1) continue;
				
				if(!used[r][c]) {
					used[r][c] = true;
					deque.addLast(new int[] {r, c});
					count ++;
				}
				
			}
		}
		
		
		
		
		
		return all - count - (wallCount + 3);
		
	}
}