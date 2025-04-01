import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static int n;
    static long total;
    static List<Node>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        total = 0;
        adjList = new List[n + 1];

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

            total += w;
        }

        long answer = dijkstra(1);

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static long dijkstra(int start){
        long sum = 0;
        int count = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
           return Integer.compare(o1.weight, o2.weight);
        });

        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;

            count ++;
            sum += now.weight;

//            System.out.println(now.to + " " + now.weight);
            if(count == n) return total - sum;

            for (int i = 0; i < adjList[now.to].size(); i++) {
                Node next = adjList[now.to].get(i);

                if(!visited[next.to]){
                    pq.add(new Node(next.to, next.weight));
                }

            }
        }

        return -1;
    }
}
