import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] adjList;
    static int[][] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        answer = new int[n][n];
        adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) adjList[i].add(j);
            }
        }


        for (int i = 0; i < n; i++) {
            visited = new boolean[n];

            for (int j = 0; j < adjList[i].size(); j++) {
                int next = adjList[i].get(j);
                dfs(next);
            }

            for (int j = 0; j < n; j++) {
                if(visited[j]){
                    answer[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now){
        if(visited[now]) return;
        visited[now] = true;

        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);
            dfs(next);
        }
    }
}