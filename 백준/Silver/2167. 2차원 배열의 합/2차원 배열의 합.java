import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int[][] sumArr = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                sumArr[i + 1][j + 1] += num + sumArr[i][j + 1] + sumArr[i + 1][j] - sumArr[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());

            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            int answer = sumArr[a2][b2] - sumArr[a1 - 1][b2] - sumArr[a2][b1 - 1] + sumArr[a1 - 1][b1 - 1];

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}