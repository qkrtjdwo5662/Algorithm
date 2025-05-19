import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] items;
    static int[] dist;

    static int n;
    static int m;
    static int r;

    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] adjList;
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        items = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            items[i] = num;
        }

        adjList = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }

        int answer = 0;
        for (int i = 1; i <= n ; i++) {
            answer = Math.max(dijkstra(i), answer);
        }

        System.out.println(answer);
    }

    static int dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0));
        dist = new int[n + 1];
        Arrays.fill(dist, MAX);

        dist[start] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();

            int to = now.to;

            for (int i = 0; i < adjList[to].size(); i++) {
                Node next = adjList[to].get(i);
                int nextTo = next.to;
                int nextWeight = next.weight;
                if(dist[nextTo] > dist[to] + nextWeight){
                    dist[nextTo] = dist[to] + nextWeight;
                    pq.add(new Node(nextTo, dist[nextTo]));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] <= m){
                sum += items[i];
            }
        }
        
        return sum;
    }
}
