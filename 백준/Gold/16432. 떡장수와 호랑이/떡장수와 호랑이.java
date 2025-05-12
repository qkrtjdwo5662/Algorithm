import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean flag;
    static int[][] arr;
    static boolean[][] visited;
    static int[] answer;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 일 수

        // 1000 X 9

        arr = new int[n][10];
        visited = new boolean[n][10];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
               int num = Integer.parseInt(st.nextToken());
               arr[i][j] = num;
            }
        }

        flag = false;

        dfs(0, -1);
        if(!flag) System.out.println(-1);

    }
    static void dfs(int depth, int before){
        if(flag) return;

        if(depth == n){
            for (int i = 0; i < n; i++) {
                System.out.println(answer[i]);
            }
            flag = true;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(arr[depth][i] != 0 && arr[depth][i] != before && !visited[depth][i]){
                visited[depth][i] = true;
                answer[depth] = arr[depth][i];
                dfs(depth + 1, arr[depth][i]);
            }
        }
    }
}
