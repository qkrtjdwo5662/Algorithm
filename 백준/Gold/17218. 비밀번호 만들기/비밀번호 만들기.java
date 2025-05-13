import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length() ; i++) {
            for (int j = 1; j <= s2.length() ; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if(c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        int y = s1.length();
        int x = s2.length();

        StringBuilder sb = new StringBuilder();
        while(y != 0 && x != 0){
            if(s1.charAt(y - 1) == s2.charAt(x - 1)){
                y --;
                x --;

                sb.insert(0, s1.charAt(y));
            }else if(dp[y - 1][x] == dp[y][x]){
                y --;
            }else if(dp[y][x - 1] == dp[y][x]){
                x --;
            }
        }

        System.out.println(sb);
    }
}
