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

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            dp[i + 1] = dp[i] + arr[i];
        }


        int result1 = (dp[N] - dp[2]) * 2;
        int result2 = dp[N-2] * 2;

        int result3 = 0;

        for (int i = 2; i < N - 1; i++) {
            int sum = ((dp[N] - dp[1]) - arr[i]) + dp[N] - dp[i + 1];
            result1 = Math.max(result1, sum);
        }

        for (int i = N-2; i > 0 ; i--) {
            int sum = (dp[N - 1] - arr[i]) + dp[i];
            result2 = Math.max(result2, sum);
        }


        for (int i = 2; i < N; i++) {
            int sum = (dp[i] - dp[1]) + (dp[N - 1] - dp[i - 1]);

            result3 = Math.max(result3, sum);
        }

        int answer = Math.max(Math.max(result1, result2), result3);

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}