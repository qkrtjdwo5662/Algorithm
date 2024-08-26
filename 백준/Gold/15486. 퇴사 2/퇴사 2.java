import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Counsel{
        int time;
        int pay;
        public Counsel(int time, int pay){
            this.time = time;
            this.pay = pay;
        }
    }

    static Counsel[] counselArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[1_500_051]; // 주어진 상담날짜에 최대 이익
        counselArr = new Counsel[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            Counsel counsel = new Counsel(time, pay);
            counselArr[i] = counsel;
        }

        for (int i = 1; i <= n ; i++) {
            Counsel now = counselArr[i];
            int time = now.time;
            int pay = now.pay;

            if(dp[i] < dp[i - 1]){
                dp[i] = dp[i - 1];
            }

            dp[i + time - 1] = Math.max(dp[i + time - 1], dp[i - 1] + pay);
        }

        System.out.println(dp[n]);
    }
}