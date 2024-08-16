import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j <= y ; j++) {
                union(j, y);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n ; i++) {
            set.add(find(parent[i]));
        }

        sb.append(set.size()).append("\n");
        System.out.println(sb);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x >= y){
            parent[y] = x;
        }else parent[x] = y;
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}