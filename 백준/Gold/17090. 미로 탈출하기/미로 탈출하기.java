import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static ArrayDeque<int[]> deque;
    static boolean[][] visited;
    static int n;
    static int m;
    // U R D L
    static int[] ry = {-1, 0, 1, 0};
    static int[] rx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n + 2][m + 2];
        visited = new boolean[n + 2][m + 2];
        deque = new ArrayDeque<>();

        for (int i = 1; i < n + 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 1; j < m + 1 ; j++) {
                map[i][j] = String.valueOf(s.charAt(j - 1));
            }
        }

        for (int i = 1; i < n + 1; i++) {
            int j = 0;
            deque.addLast(new int[]{i, j});
            visited[i][j] = true;
            j = m + 1;
            deque.addLast(new int[]{i, j});
            visited[i][j] = true;
        }

        for (int i = 1; i < m + 1; i++) {
            int j = 0;
            deque.addLast(new int[]{j, i});
            visited[j][i] = true;
            j = n + 1;
            deque.addLast(new int[]{j, i});
            visited[j][i] = true;
        }


        bfs();
        int answer = 0;
        for (int i = 1; i < n + 1 ; i++) {
            for (int j = 1; j < m + 1 ; j++) {
                if(visited[i][j]) {
                    answer++;
                }
            }
        }



        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bfs(){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            int ny = now[0];
            int nx = now[1];

            for (int i = 0; i < 4; i++) {
                int r = ny + ry[i];
                int c = nx + rx[i];

                if (r < 0 || r >= n + 2 || c < 0 || c >= m + 2) continue;

                if (map[r][c] == null) continue;

                if (visited[r][c]) continue;

                if ((i == 0 && map[r][c].equals("D")) || (i == 1 && map[r][c].equals("L")) || (i == 2 && map[r][c].equals("U")) ||
                        (i == 3 && map[r][c].equals("R"))) {
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                }
            }
        }
    }
}
