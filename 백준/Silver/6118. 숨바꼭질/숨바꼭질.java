import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max;
    static int index;
    static int count;
    static int n;
    static List<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }
        bfs(1);

        sb.append(index).append(" ").append(max).append(" ").append(count).append("\n");
        System.out.println(sb);

    }

    static void bfs(int start){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        visited[start] = true;
        deque.addLast(start);
        int[] dist = new int[n + 1];

        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }

        index = 0;
        max = 0;
        count = 0;

        for (int i = 1; i <= n; i++) {
            if(max < dist[i]){
                max = dist[i];
                count = 1;
            }else if(max == dist[i]) count ++;
        }

        for (int i = 1; i <= n ; i++) {
            if(max == dist[i]) {
                index = i;
                break;
            }
        }

    }
}
