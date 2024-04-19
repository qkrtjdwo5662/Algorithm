import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int to;
        long weight;
        public Node(int to, long weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static int n;
    static int m;
    static int k;

    static ArrayList<Node>[] adjList;
    static final long INF = Long.MAX_VALUE;

    static PriorityQueue<Node> pq;
    static long[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());

            adjList[v].add(new Node(u, weight));
        }

        st = new StringTokenizer(br.readLine());

        dist = new long[n + 1];
        Arrays.fill(dist, INF);
        pq = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o1.weight, o2.weight);
        });

        for (int i = 0; i < k; i++) {

            int num = Integer.parseInt(st.nextToken());

            pq.add(new Node(num, 0));
            dist[num] = 0;
        }
        visited = new boolean[n + 1];
        dijkstra();

        long max = 0;
        for (int i = 1; i <= n ; i++) {
            max = Math.max(dist[i], max);
        }

        int index = 0;
        for (int i = 1; i <= n ; i++) {
            if(max == dist[i]){
                index = i;
                break;
            }
        }

        sb.append(index).append("\n");
        sb.append(max).append("\n");
        System.out.println(sb);

    }

    static void dijkstra(){
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;


            for (int i = 0; i < adjList[now.to].size(); i++) {
                Node next = adjList[now.to].get(i);

                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }



    }
}