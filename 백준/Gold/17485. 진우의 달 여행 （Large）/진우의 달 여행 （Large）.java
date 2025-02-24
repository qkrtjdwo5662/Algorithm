import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = arr[0][i];
            }
        }

        // 0 : 직진
        // 1 : 왼쪽
        // 2 : 오른쪽

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j == 0){
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][0] = dp[i - 1][j + 1][2] + arr[i][j];
                    continue;
                }else if(j == m - 1){
                    dp[i][j][2] = Math.min(dp[i - 1][j][0], dp[i - 1][j - 1][1]) + arr[i][j];
                    dp[i][j][0] = dp[i - 1][j - 1][1] + arr[i][j];
                    continue;
                }

                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j + 1][2]) + arr[i][j];
                dp[i][j][0] = Math.min(dp[i - 1][j + 1][2], dp[i - 1][j - 1][1]) + arr[i][j];
                dp[i][j][2] = Math.min(dp[i - 1][j][0], dp[i - 1][j - 1][1]) + arr[i][j];

            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            answer = Math.min(dp[n - 1][i][0], answer);
            answer = Math.min(dp[n - 1][i][1], answer);
            answer = Math.min(dp[n - 1][i][2], answer);
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }


}
