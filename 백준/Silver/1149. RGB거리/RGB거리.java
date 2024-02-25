import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 987654321;
            }
        }



        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + arr[i][0], dp[i - 1][2] + arr[i][0]);

            dp[i][1] = Math.min(dp[i - 1][0] + arr[i][1], dp[i - 1][2] + arr[i][1]);

            dp[i][2] = Math.min(dp[i - 1][0] + arr[i][2], dp[i - 1][1] + arr[i][2]);
        }

        int answer = 987654321;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp[n-1][i]);
        }


        sb.append(answer);
        System.out.println(sb);

    }
}