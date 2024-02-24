import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= tc ; t++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int[][] dp = new int[a.length() + 1][b.length() + 1];

            for (int i = 1; i <= a.length() ; i++) {
                for (int j = 1; j <= b.length(); j++) {
                    if(a.charAt(i - 1) == b.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(dp[a.length()][b.length()]).append("\n");
        }
        System.out.println(sb);

    }
}