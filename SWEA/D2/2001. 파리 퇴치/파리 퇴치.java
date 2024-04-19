import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[][] board;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= tc ; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            board = new int[n +1][n + 1];
            sum = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[i][j] = num;
                    sum[i][j] = num;

                    sum[i][j] += sum[i-1][j];
                    sum[i][j] += sum[i][j-1];
                    sum[i][j] -= sum[i-1][j-1];
                }
            }

            int max = 0;
            for (int i = 0; i <= n-m; i++) {
                for (int j = 0; j <= n-m ; j++) {
                    int kill = sum[i + m][j + m] - sum[i+m][j]- sum[i][j + m] + sum[i][j];
                    max = Math.max(max, kill);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);


    }
}