import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < n; j++) {
                    board[i][j] = s.charAt(j) - '0';
                }
            }

            int answer = 0;

            for (int i = 0; i < n; i++) {
                int index = 0;

                if(i <= n/2) index = i;
                else index = (n - 1) - i;

                for (int j = n/2 - index; j <= n/2 + index; j++) {
                    answer += board[i][j];
                }
            }

            sb.append("#").append(t).append(" ");
            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }
}