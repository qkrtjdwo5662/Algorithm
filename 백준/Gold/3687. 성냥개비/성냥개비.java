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

        int tc = Integer.parseInt(st.nextToken());
        int[] arr = new int[9];
        long[] dp = new long[101];

        Arrays.fill(dp, Long.MAX_VALUE);

        arr[2] = 1;
        arr[3] = 7;
        arr[4] = 4;
        arr[5] = 2;
        arr[6] = 0; // or 6
        arr[7] = 8;
        arr[8] = 10;

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6; // or 6
        dp[7] = 8;
        dp[8] = 10;

        for (int i = 9; i <= 100 ; i++) { // dp
            StringBuilder a;
            for (int j = 2; j <= 7; j++) { // arr
                a = new StringBuilder();
                a.append(dp[i - j]).append(arr[j]);
                dp[i] = Math.min(dp[i], Long.parseLong(a.toString()));
            }
        }

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()); // 성냥개비 개수

            sb.append(dp[num]).append(" ");

            int quo = num / 2;
            if(num % 2 == 1){
                sb.append(7);
            }else sb.append(1);

            for (int i = 0; i < quo - 1; i++) {
                sb.append(1);
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}