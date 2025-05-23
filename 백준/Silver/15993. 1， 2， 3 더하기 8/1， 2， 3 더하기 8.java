import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 1_000_000_009;
    static int SIZE = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        int[][] dp = new int[SIZE + 1][2];
        // 0 : 홀수
        // 1 : 짝수

        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[3][0] = 1;
        // 3
        // 1 1 1
        // 1 2
        // 2 1
        // 3

        for (int i = 2; i <= SIZE; i++) {
            dp[i][0] += dp[i - 1][1];
            dp[i][0] %= MOD;

            dp[i][1] += dp[i - 1][0];
            dp[i][1] %= MOD;

            if(i - 2 >= 0){
                dp[i][0] += dp[i - 2][1];
                dp[i][0] %= MOD;

                dp[i][1] += dp[i - 2][0];
                dp[i][1] %= MOD;
            }

            if(i - 3 >= 0){
                dp[i][0] += dp[i - 3][1];
                dp[i][0] %= MOD;

                dp[i][1] += dp[i - 3][0];
                dp[i][1] %= MOD;
            }
        }

        // dp1 n을 이루는 짝수개의 개수
        // dp2 n을 이루는 홀수개의 개수
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);

    }

}
