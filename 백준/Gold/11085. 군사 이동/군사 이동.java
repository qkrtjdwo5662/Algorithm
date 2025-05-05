import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int p;

    static class Edge{
        int from;
        int to;

        int width;

        public Edge(int from, int to, int width){
            this.to = to;
            this.from = from;
            this.width = width;
        }
    }
    static List<Edge> edgeList;
    static int[] parent;
    static int[] info;
    public static void main(String[] args) throws IOException {
        // 수도에서 수도로 가는길을 가장 넓이가 큰 경로로만 간다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        p = Integer.parseInt(st.nextToken()); // 지점
        int w = Integer.parseInt(st.nextToken()); // 길의 개수

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();
        parent = new int[p];
        info = new int[p];
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(u, v, width));
            edgeList.add(new Edge(v, u, width));
        }

        for (int i = 0; i < p; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList, (o1, o2) -> {
            return o2.width - o1.width;
        });

        for (int i = 0; i < edgeList.size(); i++) {
            Edge now = edgeList.get(i);
            int u = now.to;
            int v = now.from;
            int width = now.width;

            if(find(u) != find(v)){
                union(u, v);
                info[v] = width;
            }

            if(find(s) == find(e)) break;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < p; i++) {
            if(info[i] != 0) min = Math.min(min, info[i]);
        }

        System.out.println(min);
    }
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x != y) {
            parent[x] = y;
        }
    }
    static int find(int a){
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }
}
