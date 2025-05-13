import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayDeque<int[]> deque;
    static int n;
    static int m;
    static int[][] board;
    static int[][] answer;
    static boolean[][] visited;

    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int sy = -1;
        int sx = -1;

        board = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];
        deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                if(num == 2) {
                    sy = i;
                    sx = j;
                }else if(num == 1){
                    answer[i][j] = -1;
                }
            }
        }

        bfs(sy, sx);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        // 0 갈 수 없는 땅
        // 1 갈 수 있는 땅
        // 2 목표 지점
    }

    static void bfs(int sy, int sx){
        deque.addLast(new int[]{sy, sx});
        visited[sy][sx] = true;

        while (!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r>= n || c>= m ) continue;

                if(board[r][c] == 0){
                    answer[r][c] = 0;
                    continue;
                }

                if(visited[r][c]) continue;

                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
                answer[r][c] = answer[now[0]][now[1]] + 1;
            }
        }
    }
}
