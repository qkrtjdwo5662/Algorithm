import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean flag;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        flag = false;
        dfs(n, 0);
        System.out.println(sb);
    }

    static void dfs(int now, int depth){
        if(flag) return;

        if(now <= 0) return;

        if(now == 1){
            if(depth % 2 == 1){
                sb.append("CY").append("\n");

            }else{
                sb.append("SK").append("\n");
            }
            flag = true;
            return;
        }

        dfs(now -1, depth + 1);
        dfs(now -3, depth + 1);
    }
}