import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int won = Integer.parseInt(st.nextToken());
                arr[i] = won;
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n ; i++) {
                int won = arr[i - 1];
                dp[i][0] = 1;
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j];

                    if(j >= won) dp[i][j] += dp[i][j - won];

                }
            }
//            System.out.println(Arrays.deepToString(dp));
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
    }
}