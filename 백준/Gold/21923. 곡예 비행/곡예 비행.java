import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        int[][] up = new int[n + 1][m + 1];
        int[][] down = new int[n + 1][m + 1];

        for (int i = n; i >= 1 ; i--) {
            for (int j = 1; j <= m ; j++) {
                if(i == n && j == 1) {
                    up[i][j] = map[i][j]; // 시작점
                    continue;
                }

                if(i == n){
                    up[i][j] = up[i][j - 1] + map[i][j];
                    continue;
                }else if(j == 1){
                    up[i][j] = up[i + 1][j] + map[i][j];
                    continue;
                }

                up[i][j] = Math.max(up[i + 1][j], up[i][j - 1]) + map[i][j];
            }
        }

        for (int i = n; i >= 1 ; i--) {
            for (int j = m; j >= 1 ; j--) {
                if(i == n && j == m){
                    down[i][j] = map[i][j];
                    continue;
                }

                if(i == n){
                    down[i][j] = down[i][j + 1] + map[i][j];
                    continue;
                }else if(j == m){
                    down[i][j] = down[i + 1][j] + map[i][j];
                    continue;
                }


                down[i][j] = Math.max(down[i + 1][j], down[i][j + 1]) + map[i][j];
            }
        }
        

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                max = Math.max(max, up[i][j] + down[i][j]);
            }
        }

        sb.append(max).append("\n");
        System.out.println(sb);

    }
}
