import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        // ACAYKP
        // CAPCAK

        //   A C A Y K P
        // C 0
        // A 1
        // P 1
        // C 1
        // A 1
        // K 1
        // 두문자열의 최장 공통 부분 수열

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int answer = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if(c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
