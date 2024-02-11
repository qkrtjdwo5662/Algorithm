import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] result;
    static int[] praise;
    static ArrayList<Integer>[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            parents[i] = new ArrayList<>();
        }

        result = new int[n+1];
        praise = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) continue;

            parents[num].add(i);
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            praise[num] += w;

        }

        dfs(1, 0);

        for (int i = 1; i <= n ; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

    }

    static void dfs(int num, int w){
        w += praise[num];
        result[num] = w;

        for (int i = 0; i < parents[num].size(); i++) {
            int child = parents[num].get(i);

            dfs(child, w);
        }

    }
}