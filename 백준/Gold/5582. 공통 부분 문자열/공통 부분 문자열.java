import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int answer = 0;
        for (int i = 1; i <= s1.length() ; i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if(c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;

                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
