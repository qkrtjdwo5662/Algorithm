import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] parents;

    static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static Edge[] edgeList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;
            parents = new int[n];
            edgeList = new Edge[m];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

            int total = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                total += z;
                Edge edge = new Edge(x, y, z);
                edgeList[i] = edge;
            }

            Arrays.sort(edgeList, (o1, o2) -> {
                return Integer.compare(o1.weight, o2.weight);
            });


            int count = 0;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                Edge now = edgeList[i];

                if(union(now.start, now.end)){
                    count++;
                    sum += now.weight;
                }

                if(count == n - 1) break;
            }

            sb.append(total - sum).append("\n");
        }

        System.out.println(sb);
    }

    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x == y) return false;

        parents[x] = y;
        return true;
    }

    static int find(int a){
        if(parents[a] == a){
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}