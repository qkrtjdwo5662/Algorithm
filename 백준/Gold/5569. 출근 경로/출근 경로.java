import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[h + 1][w + 1][4];

        for (int i = 1; i <= h ; i++) {
            dp[i][1][0] = 1;
        }

        for (int i = 1; i <= w ; i++) {
            dp[1][i][2] = 1;
        }

        for (int i = 2; i <= h ; i++) {
            for (int j = 2; j <= w ; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;

                dp[i][j][1] = (dp[i - 1][j][2]) % MOD;

                dp[i][j][2] = (dp[i][j - 1][2] + dp[i][j - 1][3]) % MOD;

                dp[i][j][3] = (dp[i][j - 1][0]) % MOD;
            }
        }

        int answer = (dp[h][w][0] + dp[h][w][1] + dp[h][w][2] + dp[h][w][3]) % MOD;
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}