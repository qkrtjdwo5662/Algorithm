import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n;
	static boolean[] visited;
	static int[] board;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n + 1];
			visited = new boolean[n + 1];
			count = 0;
			backtrack(1);
			sb.append("#").append(i).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void backtrack(int depth) {
		if(depth == n+1) {
			count += 1;
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(!visited[i]) {
				boolean check = false;
				board[depth] = i;
				
				for (int j = 1; j < depth; j++) {
					
					if(Math.abs(depth - j) == Math.abs(board[depth] - board[j])) {
						check = true;
						break;
					}
				}
				
				if(!check) {
					visited[i] = true;
					backtrack(depth + 1);
					visited[i] = false;
				}
				board[depth] = 0;
			}
			
		}
	}
}