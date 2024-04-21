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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] dp = new int[n];

        dp[0] = 1;

        // 10 20 10 30 20 50
        // 1  2  1  3  2  4

        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]){
                int max = dp[i-1];
                for (int j = i - 2; j >= 0 ; j--){
                    if(arr[i] > arr[j])  max = Math.max(dp[j], max);
                }

                dp[i] = max + 1;
            }else{
                int max = 0;
                for (int j = i - 2; j >= 0 ; j--){
                    if(arr[i] > arr[j])  max = Math.max(dp[j], max);
                }
                dp[i] = max + 1;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}