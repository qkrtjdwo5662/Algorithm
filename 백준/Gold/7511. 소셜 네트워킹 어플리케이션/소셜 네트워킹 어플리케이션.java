import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            parent = new int[n];

            for (int i = 1; i < n ; i++) {
                parent[i] = i;
            }
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            sb.append("Scenario ");
            sb.append(t);
            sb.append(":").append("\n");

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if(find(u) == find(v)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }
    static int find(int a){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}