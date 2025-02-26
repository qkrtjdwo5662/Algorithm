import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] board;
    static boolean[][][] visited;
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                int num = s.charAt(j) - '0';
                board[i][j] = num;
            }
        }

        visited = new boolean[n][m][k + 1];

        answer = 1_000_000;
        bfs();
        if(answer == 1_000_000){
            sb.append(-1).append("\n");
        }else sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bfs(){
        int y = 0;
        int x = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        visited[y][x][0] = true;
        deque.addLast(new int[]{y, x, 1, 0});
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            int ny = now[0];
            int nx = now[1];
            int d = now[2];
            int count = now[3];

            if(ny == n - 1 && nx == m - 1){
                answer = Math.min(answer, d);
            }

            for (int i = 0; i < 4; i++) {
                int r = ny + ry[i];
                int c = nx + rx[i];

                if(r < 0 || c< 0 || r>= n || c>= m) continue;

                if(board[r][c] == 1){
                    if(count + 1 <= k && !visited[r][c][count + 1]){
                        visited[r][c][count + 1] = true;
                        deque.addLast(new int[]{r, c, d + 1, count + 1});
                    }
                }else if(board[r][c] == 0){
                    if(!visited[r][c][count]){
                        visited[r][c][count] = true;
                        deque.addLast(new int[]{r, c, d +1, count});
                    }
                }
            }

        }


    }
}
