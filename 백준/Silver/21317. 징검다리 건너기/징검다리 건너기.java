import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[][] arr = new int[n + 1][2];
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][2];

        // 초기값 설정
        dp[1][0] = 0;
        dp[1][1] = INF;
        dp[2][0] = arr[1][0];
        dp[2][1] = INF;
        if (n > 2) {
            dp[3][0] = Math.min(dp[2][0] + arr[2][0], arr[1][1]);
            dp[3][1] = INF;
        }

        // 점화식 계산
        for (int i = 4; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i - 1][0], dp[i - 2][0] + arr[i - 2][1]);
            dp[i][1] = Math.min(dp[i - 3][0] + k, Math.min(dp[i - 1][1] + arr[i - 1][0], dp[i - 2][1] + arr[i - 2][1]));
        }

        // 결과 계산
        int answer = Math.min(dp[n][0], dp[n][1]);
        System.out.println(answer);
    }
}