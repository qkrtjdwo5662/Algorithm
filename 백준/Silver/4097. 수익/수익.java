import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while((n = Integer.parseInt(br.readLine())) != 0){
            // -3, 4, 9, -2, -5, 8
            // 2 ~ 6 : 4 + 9 + -2 + -5 + 8 => 14
            int[] arr = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                arr[i] = num;
            }

            dp[0] = arr[0];
            int max = Integer.MIN_VALUE;
            for(int i= 1; i < n; i++){
                dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
                max = Math.max(max, dp[i]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}