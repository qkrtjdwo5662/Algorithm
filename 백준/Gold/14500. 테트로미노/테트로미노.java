import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;

    public static int[] rx = {0, 0, -1, 1};
    public static int[] ry = {1, -1, 0, 0};

    public static int[][] board;
    public static boolean[][] visited;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        visited = new boolean[n][m];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j, board[i][j], 1);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int row, int col, int now, int count){
        if(count == 4){
            answer = Math.max(answer, now);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = ry[i] + row;
            int c = rx[i] + col;

            if(r >= n || c >= m || r < 0 || c < 0){
                continue;
            }

            if(!visited[r][c]){
                if(count == 2){
                    visited[r][c] = true;
                    dfs(row, col, now+board[r][c], count+1);
                    visited[r][c] = false;
                }
                visited[r][c] = true;
                dfs(r, c, now+board[r][c], count+1);
                visited[r][c] = false;
            }
        }
    }
}
