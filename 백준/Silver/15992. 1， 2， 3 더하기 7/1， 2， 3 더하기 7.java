import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1001][1001];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= 1000 ; j++) {
                dp[i][j] += dp[i - 1][j - 1];
                dp[i][j] %= MOD;

                if(i - 2 >= 0){
                    dp[i][j] += dp[i - 2][j - 1];
                    dp[i][j] %= MOD;
                }

                if(i - 3 >= 0){
                    dp[i][j] += dp[i - 3][j - 1];
                    dp[i][j] %= MOD;
                }

            }
        }

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(dp[n][m]).append("\n");
        }

        System.out.println(sb);

    }

}
