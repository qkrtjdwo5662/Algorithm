import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[2][n];
            answer = 0;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                }
            }

            int[][] dp = new int[2][n];
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            if(n <= 1){
                sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
                continue;
            }

            dp[0][1] = map[0][1] + map[1][0];
            dp[1][1] = map[0][0] + map[1][1];

            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[1][i - 1]) + map[0][i];
                dp[1][i] = Math.max(Math.max(dp[1][i - 2], dp[0][i - 2]), dp[0][i - 1]) + map[1][i];
            }

            sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
        }
        System.out.println(sb);
    }
}