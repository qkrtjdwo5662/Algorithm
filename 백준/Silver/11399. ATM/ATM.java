import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
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

        Arrays.sort(arr);

        int[] dp = new int[n + 1];

        int answer = 0;
        for (int i = 1; i <= n ; i++) {
            dp[i] += arr[i-1] + dp[i - 1];
            answer += dp[i];
        }
        System.out.println(answer);
        System.out.println(sb);


    }
}