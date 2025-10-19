import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            arr[i][0] = s;
            arr[i][1] = e;
            arr[i][2] = num;
        }

        // 호율적으로 배치하는 경우 -> 가능한 많은 사람을 회의 시키는 것
        int[] dp = new int[n];

        dp[0] = arr[0][2];
        if(n == 1) {
            System.out.println(dp[0]);
            return;
        }

        dp[1] = Math.max(dp[0], arr[1][2]);
        for (int i = 2; i < n; i++) {
            int num = arr[i][2];

            dp[i] = Math.max(dp[i - 1],  dp[i -2] + num);
        }

        System.out.println(dp[n -1 ]);
    }
}
