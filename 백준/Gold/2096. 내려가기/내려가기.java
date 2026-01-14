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
        int[][] map = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        int[][] dp_max = new int[n][3];
        int[][] dp_min = new int[n][3];

        dp_max[0][0] = map[0][0];
        dp_max[0][1] = map[0][1];
        dp_max[0][2] = map[0][2];

        dp_min[0][0] = map[0][0];
        dp_min[0][1] = map[0][1];
        dp_min[0][2] = map[0][2];



        for (int i = 1; i < n ; i++) {
            Arrays.fill(dp_min[i], Integer.MAX_VALUE);

            dp_max[i][0] = Math.max(dp_max[i - 1][0], dp_max[i - 1][1]) + map[i][0];

            dp_max[i][1] = Math.max(Math.max(dp_max[i - 1][0], dp_max[i - 1][1]), dp_max[i - 1][2]) + map[i][1];

            dp_max[i][2] = Math.max(dp_max[i - 1][1], dp_max[i - 1][2]) + map[i][2];

            dp_min[i][0] = Math.min(dp_min[i - 1][0], dp_min[i - 1][1]) + map[i][0];

            dp_min[i][1] = Math.min(Math.min(dp_min[i - 1][0], dp_min[i - 1][1]), dp_min[i - 1][2]) + map[i][1];

            dp_min[i][2] = Math.min(dp_min[i - 1][1], dp_min[i - 1][2]) + map[i][2];
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(dp_max[n - 1][i], max);
            min = Math.min(dp_min[n - 1][i], min);
        }

        sb.append(max + " " + min).append("\n");
        System.out.println(sb);
    }
}
