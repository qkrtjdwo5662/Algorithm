import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Edge{
        int from;
        int to;
        long cost;

        public Edge(int from, int to, long cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static Node[] nodeList;
    static int[] parent;

    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodeList = new Node[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodeList[i] = new Node(x, y);
            parent[i] = i;
        }

        int count = 0;
        double answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(union(a, b)) count ++;
        }

        edgeList = new Edge[n * (n - 1) / 2];

        int index = 0;

        for (int i = 1; i <= n - 1 ; i++) {
            for (int j = i + 1; j <= n ; j++) {

                Node node1 = nodeList[i];
                Node node2 = nodeList[j];

                long diff = (long)(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));

                edgeList[index ++] = new Edge(i, j, diff);
            }
        }

        Arrays.sort(edgeList, (o1, o2) -> {
            return Double.compare(o1.cost, o2.cost);
        });

        for (int i = 0; i < edgeList.length; i++) {
            Edge edge = edgeList[i];
            int to = edge.to;
            int from = edge.from;

            if(union(to, from)){
                count ++;
                answer += Math.sqrt(edge.cost);
            }

            if(count == n - 1) break;
        }

        sb.append(String.format("%.2f", answer)).append("\n");
        System.out.println(sb);


    }

    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x == y){
            return false;
        }else {
            parent[x] = y;
            return true;
        }
    }

    static int find(int a){
        if(parent[a] == a) return parent[a];
        return parent[a] = find(parent[a]);
    }
}
