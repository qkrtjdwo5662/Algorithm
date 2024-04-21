import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Greet{
        int sad;
        int happy;
    }

    static Greet[] greetArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        greetArr = new Greet[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int sad = Integer.parseInt(st.nextToken());
            Greet greet = new Greet();

            greet.sad = sad;
            greetArr[i] = greet;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int happy = Integer.parseInt(st.nextToken());
            Greet now = greetArr[i];
            now.happy = happy;
        }

        int[][] dp = new int[n + 1][101];


        for (int i = 1; i <= n ; i++) {
            Greet now = greetArr[i - 1];

            for (int j = 0; j <= 100 ; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= now.sad){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - now.sad] + now.happy);
                }
            }
        }

        sb.append(dp[n][99]);
        System.out.println(sb);
    }
}