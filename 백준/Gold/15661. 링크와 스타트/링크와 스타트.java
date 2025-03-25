import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        answer = Integer.MAX_VALUE;
        for (int i = 1; i < n ; i++) {
            dfs(0, i, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int index, int m, int count){
        if(count == m){
            diffMax();
            return;
        }

        if(index == n){
            return;
        }

        visited[index] = true;
        dfs(index + 1, m, count + 1);
        visited[index] = false;
        dfs(index + 1, m, count);
    }

    static void diffMax(){
        int first = 0;
        int second = 0;
        for (int i = 0; i < n - 1; i++) {
            if(!visited[i]){
                for (int j = i + 1; j < n ; j++) {
                    if(!visited[j]){
                        first += arr[i][j] + arr[j][i];
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if(visited[i]){
                for (int j = i + 1; j < n ; j++) {
                    if(visited[j]){
                       second  += arr[i][j] + arr[j][i];
                    }
                }
            }
        }

        answer = Math.min(answer, Math.abs(first - second));
    }
}
