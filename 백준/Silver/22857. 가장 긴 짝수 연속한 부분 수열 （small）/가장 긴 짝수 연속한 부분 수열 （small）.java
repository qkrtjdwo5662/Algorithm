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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[][] dp = new int[n + 1][k + 1];

        int max = 0;
        for (int i = 1; i <= n ; i++) {
            if(arr[i - 1] % 2 == 0){
                // 짝수
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j] + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }else{
                // 홀수
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(max);
    }
}
