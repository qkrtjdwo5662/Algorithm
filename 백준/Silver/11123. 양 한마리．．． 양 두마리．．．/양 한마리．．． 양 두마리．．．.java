import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < m; j++) {
                    if(s.charAt(j) == '#') map[i][j] = 1;
                }
            }
            visited = new boolean[n][m];
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j] && map[i][j] == 1){
                        bfs(i, j);
                        answer ++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int startY, int startX){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{startY, startX});
        visited[startY][startX] = true;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c< 0 || r>= n || c>= m) continue;

                if(map[r][c] != 1) continue;

                if(visited[r][c]) continue;

                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
            }
        }
    }
}