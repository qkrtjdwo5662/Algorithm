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
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        answer = Integer.MAX_VALUE;
        dfs(0, 1, 0, 0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dfs(int depth, int a, int b, int count){
        if(depth == n ){
            if(count > 0){
                answer = Math.min(answer, Math.abs(a - b));
            }
            return;
        }
        dfs(depth + 1, a, b, count);
        dfs(depth + 1, a * arr[depth][0], b + arr[depth][1], count + 1);
    }
}