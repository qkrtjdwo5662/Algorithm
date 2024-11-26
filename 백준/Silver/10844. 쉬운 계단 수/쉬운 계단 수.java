import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        
        long[][] dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] % MOD;

            for (int j = 1; j < 10 ; j++) {
                if(j < 9){
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }else {
                    dp[i][9] = dp[i - 1][8] % MOD;
                }
            }
        }

        long answer = 0;

        for (int i = 1; i < 10 ; i++) {
            answer += dp[n][i] % MOD;
        }

        sb.append(answer % MOD).append("\n");
        System.out.println(sb);


    }
}