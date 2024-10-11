import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        backtrack(n, m, 0, "");

    }

    static void backtrack(int n, int m, int depth, String s){
        if(depth == m){
            System.out.println(s);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(n, m, depth + 1, s +i + " ");
                visited[i] = false;
            }

        }
    }
}