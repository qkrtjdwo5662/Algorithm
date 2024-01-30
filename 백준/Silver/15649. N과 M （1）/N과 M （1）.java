import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static StringBuilder sb;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // n개의 자연수 중에서 중복 없이 m개를 고른다.

        visited = new boolean[n+1];
        dfs(0, "");
        System.out.println(sb);
    }

    public static void dfs(int depth, String s){
        if(depth == m){
            sb.append(s).append("\n");
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(depth == 0){
                    dfs(depth + 1, s+i);
                }else{
                    dfs(depth + 1, s+" "+i);
                }

                visited[i] = false;
            }
        }
    }
}
