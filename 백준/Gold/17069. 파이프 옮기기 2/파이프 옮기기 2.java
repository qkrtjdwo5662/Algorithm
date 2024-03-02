import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 -> 가로, 대각선
        // 세로 -> 세로, 대각선
        // 대각선 -> 가로, 세로, 대각선
        if(board[n-1][n-1] == 1){
            System.out.println(0);
            return;
        }
        long[][][] dp = new long[n][n][3];

        dp[0][1][0] = 1;




        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if(board[i][j] == 1) continue;

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j-1][2];
                if(i == 0) continue;

                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];

                if(board[i][j - 1] == 0 && board[i-1][j] == 0){
                    dp[i][j][2]  = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }

            }
        }

        long answer = dp[n-1][n-1][0]  +dp[n-1][n-1][1] + dp[n-1][n-1][2];
        sb.append(answer).append("\n");
        System.out.println(sb);
        
    }
}