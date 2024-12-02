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
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }


        long[][] dp = new long[n][n];

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = board[i][j];
                if(num == 0) break;
                if(i + num < n) dp[i + num][j] += dp[i][j];
                if(j + num < n) dp[i][j + num] += dp[i][j];
            }
        }

        sb.append(dp[n - 1][n - 1]).append("\n");
        System.out.println(sb);
    }
}