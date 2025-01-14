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

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n ; i++) {
            dp[1][i] = dp[1][i - 1] + arr[1];
        }

        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j - i >= 0 ){
                    dp[i][j] = Math.min(dp[i - 1][j - i] + arr[i], dp[i][j - i] + arr[i]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n ; i++) {
            answer = Math.min(answer, dp[i][n]);
        }

//        System.out.println(Arrays.deepToString(dp));
        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}
