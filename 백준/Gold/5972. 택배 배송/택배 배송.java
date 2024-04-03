import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int end;
        int weight;

        public Node(int next, int weight){
            this.end = next;
            this.weight = weight;
        }


    }
    static int n;
    static int m;
    static ArrayList<Node>[] adjList;
    static boolean[] visited;
    static int answer;
    static int[] dist;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, w));
            adjList[b].add(new Node(a, w));
        }
        sb.append(dijkstra(1));
        System.out.println(sb);

    }

    static int dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.end]) continue;
            visited[now.end] = true;

            if(now.end == n) return dist[n];

            for (int i = 0; i < adjList[now.end].size(); i++) {
                Node next = adjList[now.end].get(i);
                if(dist[next.end] > dist[now.end] + next.weight){
                    dist[next.end] = dist[now.end] + next.weight;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }


        return dist[n];
    }
}