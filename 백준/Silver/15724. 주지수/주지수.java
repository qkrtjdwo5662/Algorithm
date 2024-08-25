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

        int[][] arr = new int[n + 1][m + 1];
        int[][] sumArr = new int[n + 1][m + 1];

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m ; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                sumArr[i][j] = num + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1];
            }
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            sb.append(sumArr[x2][y2] + sumArr[x1 - 1][y1 - 1] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2]).append("\n");
        }

        System.out.println(sb);
    }
}