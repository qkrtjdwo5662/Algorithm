import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        List<int[]> list = new ArrayList<>();
        while((s = br.readLine())!=null && !s.isEmpty()){
            StringTokenizer st = new StringTokenizer(s);
            int white = Integer.parseInt(st.nextToken());
            int black = Integer.parseInt(st.nextToken());

            list.add(new int[]{white, black});
        }

        N = list.size();

        int[][][] dp = new int[N][16][16];

        dp[0][1][0] = list.get(0)[0];
        dp[0][0][1] = list.get(0)[1];
        
        for (int i = 1; i < N ; i++) {
            int nw = list.get(i)[0];
            int nb = list.get(i)[1];

            for (int j = 0; j <= 15  ; j++) {

                for (int k = 0; k <= 15 ; k++) {
                    int temp1 = 0;
                    int temp2 = 0;

                    if(j > 0) temp1 = dp[i - 1][j - 1][k] + nw;
                    if(k > 0) temp2 = dp[i - 1][j][k - 1] + nb;

                    dp[i][j][k] = Math.max(Math.max(temp1, temp2), dp[i - 1][j][k]);

                }
            }
        }

        sb.append(dp[N - 1][15][15]).append("\n");
        System.out.println(sb);
    }
}
