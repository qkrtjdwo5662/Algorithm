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

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        dp[0][1] = arr[0];
        dp[0][2] = arr[0];

        for (int i = 1; i < n ; i++) {
            dp[i][0] = dp[i - 1][2];

            dp[i][1] = dp[i - 1][0] + arr[i];
            dp[i][2] = Math.max(Math.max(dp[i][0], dp[i][1]), dp[i - 1][1] + arr[i]);
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}