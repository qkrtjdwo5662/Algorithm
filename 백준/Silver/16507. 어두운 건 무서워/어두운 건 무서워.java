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

        int q = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        int[][] sum = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {

                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;
                sum[i][j] = map[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int count = (y2 - y1 + 1) * (x2 - x1 + 1);

            int answer = (sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1]) / count;
            sb.append(answer).append("\n");
        }

        System.out.println(sb);


    }

}
