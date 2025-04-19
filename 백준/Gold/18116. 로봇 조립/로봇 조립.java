import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    static final int max = 1_000_000;
    static int[] parent;
    static int[] count;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        parent = new int[max + 1];
        count = new int[max + 1];
        set = new HashSet<>();
        for (int i = 1; i <= max ; i++) {
            parent[i] = i;
            count[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            if(op.equals("I")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            } else if (op.equals("Q")) {
                int a = Integer.parseInt(st.nextToken());
                sb.append(count[find(a)]).append("\n");
            }
        }

//        System.out.println(Arrays.toString(count));
        System.out.println(sb);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x != y) {
            parent[x] = y;
            count[y] += count[x];
        }
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
