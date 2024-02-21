import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        visited = new boolean[n]; // 방문체크

//
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i, 0);
                visited[i] = false;
            }
        }
        System.out.println(0);
    }

    public static void dfs(int now, int depth){
        if(depth == 4) {
            System.out.println(1);
            System.exit(0);
            return;
        }


        for (int i = 0; i < adjList[now].size(); i++) {
            if(!visited[adjList[now].get(i)]){
                visited[adjList[now].get(i)] = true;
                dfs(adjList[now].get(i), depth+1);
                visited[adjList[now].get(i)] = false;
            }
        }
    }
}
