import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
			}
		}
		// wij -> i에서j로 가는 비용
		visited = new boolean[n];
		answer = 987654321;
		
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			backtrack(1, i, i, 0);
			visited[i] = false;
		}
		
		sb.append(answer).append("\n");
		System.out.println(sb);
	}
	
	static void backtrack(int depth, int start, int now, int sum) {
		if(depth == n) {
			if(board[now][start] > 0) {
				answer = Math.min(answer, sum + board[now][start]);
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				if(board[now][i] == 0 || now == i) continue;
				
				visited[i] = true;
				backtrack(depth + 1, start ,i, sum + board[now][i]);
				visited[i] = false;
			}
		}
		
	}
}