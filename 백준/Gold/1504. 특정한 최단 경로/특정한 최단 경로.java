import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

    }

    static int n;
    static ArrayList<Node>[] adjList;
    static int v1;
    static int v2;
    static final int INF = 987654321;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        dijkstra(1);
        int sToV1 = dist[v1];
        int sToV2 = dist[v2];

        dijkstra(v1);
        int v1ToV2 = dist[v2];
        int v1ToN = dist[n];

        dijkstra(v2);
        int v2ToN = dist[n];

        int answer = Math.min(sToV1 + v1ToV2 + v2ToN, sToV2 + v1ToV2 + v1ToN);
        if(v1ToV2 >= INF || answer >= INF) sb.append(-1).append("\n");
        else sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });
        dist = new int[n + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node edge = pq.poll();


            for (int i = 0; i < adjList[edge.to].size(); i++) {
                Node next = adjList[edge.to].get(i);
                if(dist[next.to] > dist[edge.to] + next.weight){
                    dist[next.to] = dist[edge.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        
    }
}