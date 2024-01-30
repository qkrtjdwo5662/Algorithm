import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= tc; i++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int[][] board = new int[n][n];

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				for (int k = 0; k < n; k++) {
					board[j][k] = s.charAt(k) - '0';
				}
			}
			int answer = getTotal(board);
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static int getTotal(int[][] board) {
		int total = 0;
		int index = 0;

		int n = board.length;
		int middle = board.length/2;

		for (int i = 0; i < middle; i++) {
			for (int j = middle - index; j <= middle+ index; j++) {
				total += board[i][j];
			}
			index++;
		}

		for (int i = 0; i < board.length; i++) {
			total += board[middle][i];
		}
		
		index = 0;
		for (int i = n - 1; i > middle; i--) {
			for (int j = middle - index; j <= middle + index; j++) {
				total += board[i][j];
			}
			index++;
		}

		return total;
	}
}