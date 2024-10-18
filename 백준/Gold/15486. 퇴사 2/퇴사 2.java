import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][2];
        dp = new int[1_500_051];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 1; i <= n ; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            dp[i + arr[i][0] - 1] = Math.max(dp[i + arr[i][0] - 1], dp[i - 1] + arr[i][1]);
        }

        sb.append(dp[n]).append("\n");
        System.out.println(sb);
    }

}