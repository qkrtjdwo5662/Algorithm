import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][]dp = new int[1001][1001];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= s1.length() ; i++) {
            for (int j = 1; j <= s2.length(); j++) {
                max = Math.max(dp[i][j], max);
            }
        }

        StringBuilder answer = new StringBuilder();
        int y = s1.length();
        int x = s2.length();
        while(x!=0 && y!=0){
            if(s1.charAt(y-1) == s2.charAt(x-1)){
                answer.insert(0, s1.charAt(y-1));
                x--;
                y--;
            }else if(dp[y-1][x] == dp[y][x]) y--;
            else if(dp[y][x-1] == dp[y][x]) x--;

        }
        System.out.println(max);
        System.out.println(answer);

    }
}
