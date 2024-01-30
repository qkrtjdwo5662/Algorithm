import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int[][] board;
    public static int n;
    public static int m;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - 'A';
            }
        }
        boolean[] used = new boolean[('Z' - 'A') + 1];

        answer =0;
        used[board[0][0]] = true;
        dfs(1, new int[]{0, 0}, used);
        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    public static void dfs(int count, int[] now, boolean[] used){
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c<0 || r>= n || c>= m) continue;

            if(!used[board[r][c]]){
                used[board[r][c]] = true;
                dfs(count+1, new int[]{r, c}, used);
                used[board[r][c]] = false;
            }
        }

    }
}