import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Bus{
        int end;
        int fee;

        public Bus(int end, int fee){
            this.end = end;
            this.fee = fee;
        }
    }

    static int n;
    static int m;
    static ArrayList<Bus>[] adjList;
    static final int INF = 987654321;
    static int[] dist;
    static int result;
    static ArrayList<Integer> list;
    static boolean flag;
    static boolean[] used;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());

            adjList[s].add(new Bus(e, fee));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        result = 0;

        dijkstra(s, e);
        result = dist[e];
        sb.append(result).append("\n");
        sb.append(list.size()).append("\n");
        for (int i = list.size() - 1; i >= 0 ; i--) {
            sb.append(list.get(i)).append(" ");
        }


        System.out.println(sb);
    }

    static void dijkstra(int start, int target){
        PriorityQueue<Bus> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.fee, o2.fee);
        });
        boolean[] visited = new boolean[n + 1];

        pq.add(new Bus(start, 0));
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        int[] parent = new int[n + 1];
        list = new ArrayList<>();
        while(!pq.isEmpty()){
            Bus now = pq.poll();
            int end = now.end;

            int fee = now.fee;
            if(end == target) break;

            if(visited[end]) continue;
            visited[end] = true;

            for (int i = 0; i < adjList[end].size(); i++) {
                Bus next = adjList[end].get(i);

                if(dist[next.end] > dist[end] + next.fee){
                    dist[next.end] = dist[end] + next.fee;
                    pq.add(new Bus(next.end, dist[next.end]));
                    parent[next.end] = end;
                }
            }
        }

        int temp = target;

        while(temp != start){
            list.add(temp);
            temp = parent[temp];
        }

        list.add(start);


    }
}