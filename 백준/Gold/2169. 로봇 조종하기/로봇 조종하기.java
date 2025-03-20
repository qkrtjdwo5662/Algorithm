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
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        int[][] dp = new int[n][m];

        dp[0][0] = board[0][0];

        // 첫번째행 -> 무조건 왼쪽에서 오른쪽으로만 이동가능
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + board[0][i];
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + board[i][j]; // 위에서 온 값 적용
            }

            int[] left = new int[m];
            int[] right = new int[m];

            left[0] = dp[i][0];

            for (int j = 1; j < m; j++) {
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + board[i][j];
            }

            right[m - 1] = dp[i][m - 1];
            for (int j = m - 2; j >= 0 ; j--) {
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + board[i][j];
            }

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        sb.append(dp[n - 1][m - 1]).append("\n");
        System.out.println(sb);
        
    }
}
