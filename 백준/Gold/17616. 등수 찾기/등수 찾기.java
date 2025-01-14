import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 학생의 수
        int m = Integer.parseInt(st.nextToken()); // m번의 질문
        int x = Integer.parseInt(st.nextToken()); // 누구?

        List<Integer>[] winList = new ArrayList[n + 1];
        List<Integer>[] loseList = new ArrayList[n + 1];

        for (int i = 1; i <= n ; i++) {
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            winList[u].add(v); // u가 v를 이긴다.
            loseList[v].add(u); // v가 u한테 졌다.
        }

        int result1 = bfs(x, loseList); //  x의 최대등수는 몇번 졌는가?
        int result2 = bfs(x, winList); // x의 최소 등수는 몇번 이겼는가?

        sb.append(result1).append(" ").append(n - (result2 - 1)).append("\n");
        System.out.println(sb);
    }

    static int bfs(int start, List<Integer>[] adjList){
        int answer = 0;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        deque.addLast(start);

        while(!deque.isEmpty()){
            answer ++;

            int now = deque.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                int next = adjList[now].get(i);

                if(!visited[next]) {
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }


        return answer;
    }
}
