import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] ry = {0, 1, 0, -1, -1, 1, 1, -1};
    static int[] rx = {1, 0, -1, 0, 1, 1, -1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        visited = new boolean[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    // 방문하지 않고 글자인 것만
                    bfs(i, j);
                    answer ++;
                }
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bfs(int y, int x){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{y, x});
        visited[y][x] = true;

        while (!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 8; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r >= n || c>= m) continue;

                if(map[r][c] == 0) continue;

                if(visited[r][c]) continue;

                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
            }
        }
    }
}
