import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Good{
        int volume;
        int cost;

        public Good(int volume, int cost){
            this.volume = volume;
            this.cost = cost;
        }
    }

    static Good[] goods;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            goods = new Good[n + 1];

            for (int j = 1; j <= n ; j++) {
                st = new StringTokenizer(br.readLine());

                int volume = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                goods[j] = new Good(volume, cost);
            }

            int[][] dp = new int[n + 1][k + 1];
            // n개의 물건을 담을때

            for (int j = 1; j <= n ; j++) {
                Good now = goods[j];
                int volume = now.volume;
                int cost = now.cost;

                for (int l = 0; l <= k; l++) {
                    dp[j][l] = dp[j - 1][l];

                    if(volume <= l){
                        dp[j][l] = Math.max(dp[j][l], dp[j - 1][l - volume] + cost);
                    }

                }
            }

            sb.append("#").append(i).append(" ").append(dp[n][k]).append("\n");
        }
        System.out.println(sb);

    }
}