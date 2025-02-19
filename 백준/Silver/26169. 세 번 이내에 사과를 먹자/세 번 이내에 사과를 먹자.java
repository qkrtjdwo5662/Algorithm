import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    static final int n = 5;
    static int[][] board;
    static boolean[][] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        st = new StringTokenizer(br.readLine());
        int nowY = Integer.parseInt(st.nextToken());
        int nowX = Integer.parseInt(st.nextToken());
        visited[nowY][nowX] = true;
        backtrack(nowY, nowX, 0, 0);
        if(flag) sb.append(1).append("\n");
        else sb.append(0).append("\n");

        System.out.println(sb);
    }

    static void backtrack(int y, int x, int depth, int count){
        if(flag) return;

        if(depth == 3){
            if(count >= 2){

                flag = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = y + ry[i];
            int c = x + rx[i];

            if(r < 0 || c < 0 || r >= n || c >= n) continue;

            if(!visited[r][c] && board[r][c] != -1){
                visited[r][c] = true;
                if(board[r][c] == 1){
                    backtrack(r, c, depth + 1, count + 1);
                }else backtrack(r, c, depth + 1, count);
                visited[r][c] = false;
            }

        }
    }

}
