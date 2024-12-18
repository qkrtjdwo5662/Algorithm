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

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][31];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;

        for (int i = 3; i <= 30 ; i++) {
            dp[i][1] = 1;
        }

        for (int i = 3; i <= 30 ; i++) {
            for (int j = 2; j <= 30 ; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        int answer = 0;
        int index = 0;
        for (int i = r; i <= r + (w - 1) ; i++) {
            for (int j = c; j <= c + index ; j++) {
                answer += dp[i][j];
            }
            index ++;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}