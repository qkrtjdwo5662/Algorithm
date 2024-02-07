import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n;
	static int m;

	static ArrayList<ArrayDeque<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				deque.addLast(num);
			}

			list.add(deque);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			int opr = Integer.parseInt(st.nextToken());
			
			if (opr == 1) {
				one();
			} else if (opr == 2) {
				two();
			} else if (opr == 3) {
				three();
			} else if (opr == 4) {
				four();
			} else if (opr == 5) {
				five();
			} else if (opr == 6) {
				six();
			}
			
			init();
			
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	static void init() {
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for (int j= 0; j < m; j++) {
				deque.addLast(board[i][j]);
			}

			list.add(deque);
		}
		
	}
	static void one() {
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			ArrayDeque<Integer> deque = list.get(n - i - 1);
			for (int j = 0; j < m; j++) {
				map[i][j] = deque.pollFirst();
			}
		}

		board = map;

	}

	static void two() {
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			ArrayDeque<Integer> deque = list.get(i);
			for (int j = 0; j < m; j++) {
				map[i][j] = deque.pollLast();
			}
		}

		board = map;
	}

	static void three() {

		int[][] map = new int[m][n];

		for (int i = 0; i < n; i++) {
			ArrayDeque<Integer> deque = list.get(n - 1 - i);
			for (int j = 0; j < m; j++) {
				map[m - j - 1][i] = deque.pollLast();
			}
		}

		board = map;
		
		int temp = n;
		n = m;
		m = temp;
	}

	static void four() {
		
		int[][] map = new int[m][n];

		for (int i = 0; i < n; i++) {
			ArrayDeque<Integer> deque = list.get(i);
			for (int j = 0; j < m; j++) {
				map[m - j - 1][i] = deque.pollFirst();
			}
		}

		board = map;
		
		int temp = n;
		n = m;
		m = temp;
	}

	static void five() {
		int[][] map = new int[n][m];

		int[][] devideMap1 = new int[n / 2][m / 2];
		int[][] devideMap2 = new int[n / 2][m / 2];
		int[][] devideMap3 = new int[n / 2][m / 2];
		int[][] devideMap4 = new int[n / 2][m / 2];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				devideMap1[i][j] = board[i][j];
			}

			for (int j = m / 2; j < m; j++) {
				devideMap2[i][j - m / 2] = board[i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				devideMap4[i - n / 2][j] = board[i][j];
			}

			for (int j = m / 2; j < m; j++) {
				devideMap3[i - n / 2][j - m / 2] = board[i][j];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = devideMap4[i][j];
			}

			for (int j = m / 2; j < m; j++) {
				map[i][j] = devideMap1[i][j - m / 2];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = devideMap3[i - n / 2][j];
			}

			for (int j = m / 2; j < m; j++) {
				map[i][j] = devideMap2[i - n / 2][j - m / 2];
			}
		}

		board = map;
	}

	static void six() {
		int[][] map = new int[n][m];

		int[][] devideMap1 = new int[n / 2][m / 2];
		int[][] devideMap2 = new int[n / 2][m / 2];
		int[][] devideMap3 = new int[n / 2][m / 2];
		int[][] devideMap4 = new int[n / 2][m / 2];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				devideMap1[i][j] = board[i][j];
			}

			for (int j = m / 2; j < m; j++) {
				devideMap2[i][j - m / 2] = board[i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				devideMap4[i - n / 2][j] = board[i][j];
			}

			for (int j = m / 2; j < m; j++) {
				devideMap3[i - n / 2][j - m / 2] = board[i][j];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = devideMap2[i][j];
			}

			for (int j = m / 2; j < m; j++) {
				map[i][j] = devideMap3[i][j - m / 2];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = devideMap1[i - n / 2][j];
			}

			for (int j = m / 2; j < m; j++) {
				map[i][j] = devideMap4[i - n / 2][j - m / 2];
			}
		}

		board = map;
	}
}