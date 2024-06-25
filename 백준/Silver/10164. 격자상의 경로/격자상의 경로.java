import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[] point;

    static int[] ry = {0, 1};
    static int[] rx = {1, 0};

    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

//        int[][] board = new int[n][m];

        if(k > 0){
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    count ++;
                    if(count == k) point = new int[]{i, j};
                }
            }
        }
        answer = 0;
        dfs(0, 0, false);

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dfs(int nowY, int nowX, boolean flag){
        if(nowY == n-1 && nowX == m-1){
            if(k > 0 && flag) answer ++;
            else if(k == 0) answer ++;
            return;
        }

        if(k > 0 && (nowY == point[0] && nowX == point[1])){
            flag = true;
        }

        for (int i = 0; i < 2; i++) {
            int r = nowY + ry[i];
            int c = nowX + rx[i];

            if(r < 0 || c < 0 || r>= n || c>= m) continue;

            dfs(r, c, flag);
        }
    }
}