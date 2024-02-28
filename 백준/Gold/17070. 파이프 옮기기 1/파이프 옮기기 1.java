import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int n;
    static int[][] board;
    static int count;
    static int[] ry = {0, 1, 1};
    static int[] rx = {1, 0, 1};

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
        // 0 빈칸 // 1 벽

        count = 0;

        dfs(0, 1,0);
        sb.append(count).append("\n");
        System.out.println(sb);
    }

    static void dfs(int y, int x, int d){
        if(y == n-1 && x == n-1){
            count++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if( (d == 0 && i ==1) || (d == 1 && i == 0) ) continue;
            // 가로일때 세로 제외
            // 세로일때 가로 제외

            int r = y + ry[i];
            int c = x + rx[i];

            if(r < 0 || c < 0 || r>= n || c>= n) continue;

            if(board[r][c] == 1) continue;

            if(i== 2){
                if(board[r][c-1] == 1 || board[r-1][c] == 1) continue;
            }

            dfs(r, c, i);

        }
    }
}