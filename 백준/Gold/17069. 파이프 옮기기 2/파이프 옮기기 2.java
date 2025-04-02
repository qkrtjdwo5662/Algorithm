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

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        long[][][] dp = new long[n + 1][n + 1][3];
        // 0 : 오른쪽
        // 1 : 아래
        // 2 : 대각선

        // (1,1) ~ (1,2) 가로 방향 초기화
        dp[1][2][0] = 1;

        for (int i = 1; i <= n ; i++) {
            for (int j = 3; j <= n ; j++) {
                if(map[i - 1][j - 1] == 0){
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                    if(i >= 2 && map[i - 2][j - 1] == 0 && map[i - 1][j - 2] == 0) {
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }

            }
        }

        long answer = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        sb.append(answer).append("\n");

        System.out.println(sb);

    }
}
