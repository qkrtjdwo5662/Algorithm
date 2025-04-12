import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new List[n + 1];
        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        visited = new boolean[n + 1];
        arr = new int[3];
        answer = 0;

        backtrack(0, 0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int depth, int num){
        if(depth == 3){
            if(check()) answer ++;
            return;
        }

        for (int i = num + 1; i <= n ; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtrack(depth + 1, i);
                visited[i] = false;
            }

        }
    }

    static boolean check(){
        for (int i = 0; i < 2; i++) {
            int num1 = arr[i];

            for (int j = 0; j < adjList[num1].size(); j++) {
                int num2 = adjList[num1].get(j);

                if(visited[num1] && visited[num2]) return false;
            }
        }

        return true;
    }
}
