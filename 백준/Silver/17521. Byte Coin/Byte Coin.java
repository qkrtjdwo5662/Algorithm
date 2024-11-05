import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int w;
    static long[] arr;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        answer = 0;
        dfs(0, 0, w);

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
    static void dfs(int depth, long coin, long money){
        if(depth == n){
            answer = Math.max(answer, money);
            return;
        }

        dfs(depth+1, money/arr[depth], money%arr[depth]);
        dfs(depth+1, coin, money);
        dfs(depth+1, 0, coin * arr[depth] + money);
    }
}