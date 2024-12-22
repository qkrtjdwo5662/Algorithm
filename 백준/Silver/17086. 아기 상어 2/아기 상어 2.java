import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] ry = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] rx = {1, 0, -1, 0, -1, 1, 1, -1};
    static int answer;
    static ArrayDeque<int[]> deque = new ArrayDeque<>();
    static boolean[][] visited = new boolean[n][m];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if(num == 1) {
                    deque.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        answer = bfs();
        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static int bfs(){
        int[][] dist = new int[n][m];

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            for (int i = 0; i < 8; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c< 0 || r>= n || c>= m) continue;

                if(visited[r][c]) continue;

                visited[r][c] = true;
                dist[r][c] = dist[now[0]][now[1]] + 1;
                deque.addLast(new int[]{r, c});
            }

        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }
        return max;
    }
}