import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    static int n;
    static List<Integer>[] adjList;
    static int k;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken()); // 거의 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시의 정보

        adjList = new List[n + 1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
        }
        list = new ArrayList<>();
        // start x

        dijkstra(x);
        Collections.sort(list);

        if(list.size() == 0){
            sb.append(-1).append("\n");
        }else{
            for (int num : list) {
                sb.append(num).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int s){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        pq.add(new int[]{s, 0});
        dist[s] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(now[1] > k) return;
            else if(now[1] == k) list.add(now[0]);

            for (int i = 0; i < adjList[now[0]].size() ; i++) {
                int next = adjList[now[0]].get(i);

                if(dist[next] > dist[now[0]] + 1){
                    dist[next] = dist[now[0]] + 1;
                    pq.add(new int[]{next, dist[next]});
                }

            }
        }


    }
}
