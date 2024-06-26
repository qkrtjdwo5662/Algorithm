import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 10_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                dist[i][j] = MAX;

                if(i == j) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }


        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <=n ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(dist[i][j] == MAX){
                    sb.append(0).append(" ");
                }else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}