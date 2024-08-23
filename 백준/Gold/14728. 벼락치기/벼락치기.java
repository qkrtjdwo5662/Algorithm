import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Danwon{
        int time;
        int score;

        public Danwon(int time, int score){
            this.time = time;
            this.score = score;
        }
    }
    static Danwon[] danwons;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][t + 1]; // 각 단원별 시간당 최대 점수
        danwons = new Danwon[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            Danwon danwon = new Danwon(time, score);
            danwons[i] = danwon;
        }

        for (int i = 1; i <= n ; i++) {
            Danwon now = danwons[i - 1];
            int score = now.score;
            int time = now.time;

            for (int j = 1; j <= t; j++) {
                dp[i][j] = dp[i - 1][j];

                if(j >= time){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - time] + score);
                }
            }
        }

        sb.append(dp[n][t]).append("\n");
        System.out.println(sb);
    }
}