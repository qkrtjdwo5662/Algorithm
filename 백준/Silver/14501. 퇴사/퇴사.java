import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        answer = 0;
        dfs(1, 0, 1);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dfs(int depth, int sum, int limit){
        if(depth == n + 1){
            answer = Math.max(answer, sum);
            return;
        }

        if(limit <= depth && limit + arr[depth][0] <= n + 1){
            dfs(depth + 1, sum + arr[depth][1], limit + arr[depth][0]);
        }

        dfs(depth + 1, sum, Math.max(depth + 1, limit));

    }
}