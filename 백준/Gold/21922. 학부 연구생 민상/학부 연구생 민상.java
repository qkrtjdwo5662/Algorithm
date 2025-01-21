import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    static int answer = 0;
    static boolean[][][] visited;
    static int[][] dp;
    static ArrayDeque<int[]> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][5];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if(num == 9) {
                    deque.addLast(new int[]{i, j, -1});
                    visited[i][j][4] = true;
                    dp[i][j] = 1;
                }
            }
        }
        bfs();
        count();
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bfs(){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            int ny = now[0];
            int nx = now[1];
            int d = now[2];

            if(d == -1){ // 에어컨 시작
                for (int i = 0; i < 4; i++) {
                    int r = ny + ry[i];
                    int c = nx + rx[i];

                    if(!check(r, c)) continue;

                    if(!visited[r][c][i]){
                        visited[r][c][i] = true;
                        deque.addLast(new int[]{r, c, i});
                        dp[r][c] = 1;
                    }
                }

                continue;
            }

            if(map[ny][nx] == 1){
                if(d == 0 || d == 2){ // 그래도 진행
                    int r = ny + ry[d];
                    int c = nx + rx[d];

                    if(!check(r, c)) continue;

                    if(visited[r][c][d]) continue;
                    visited[r][c][d] = true;
                    deque.addLast(new int[]{r, c, d});
                    dp[r][c] = 1;
                }else { // 막힘

                }
            }else if(map[ny][nx] == 2){
                if(d == 1 || d == 3){
                    int r = ny + ry[d];
                    int c = nx + rx[d];

                    if(!check(r, c)) continue;

                    if(visited[r][c][d]) continue;
                    visited[r][c][d] = true;
                    deque.addLast(new int[]{r, c, d});
                    dp[r][c] = 1;
                }else { // 막힘

                }
            }else if(map[ny][nx] == 3){
                if(d == 0 || d == 2){
                    int r = ny + ry[(d + 3) % 4];
                    int c = nx + rx[(d + 3) % 4];

                    if(!check(r, c)) continue;

                    if(visited[r][c][(d + 3) % 4]) continue;
                    visited[r][c][(d + 3) % 4] = true;
                    deque.addLast(new int[]{r, c, (d + 3) % 4});
                    dp[r][c] = 1;
                }else{
                    int r = ny + ry[(d + 1) % 4];
                    int c = nx + rx[(d + 1) % 4];

                    if(!check(r, c)) continue;

                    if(visited[r][c][(d + 1) % 4]) continue;
                    visited[r][c][(d + 1) % 4] = true;
                    deque.addLast(new int[]{r, c, (d + 1) % 4});
                    dp[r][c] = 1;
                }

            }else if(map[ny][nx] == 4){
                if(d == 0 || d == 2){
                    int r = ny + ry[(d + 1) % 4];
                    int c = nx + rx[(d + 1) % 4];

                    if(!check(r, c)) continue;

                    if(visited[r][c][(d + 1) % 4]) continue;
                    visited[r][c][(d + 1) % 4] = true;
                    deque.addLast(new int[]{r, c, (d + 1) % 4});
                    dp[r][c] = 1;
                }else{
                    int r = ny + ry[(d + 3) % 4];
                    int c = nx + rx[(d + 3) % 4];

                    if(!check(r, c)) continue;

                    if(visited[r][c][(d + 3) % 4]) continue;
                    visited[r][c][(d + 3) % 4] = true;
                    deque.addLast(new int[]{r, c, (d + 3) % 4});
                    dp[r][c] = 1;
                }
            }else if(map[ny][nx] == 0){ // 빈칸 일때
                int r = ny + ry[d];
                int c = nx + rx[d];

                if(!check(r, c)) continue;

                if(visited[r][c][d]) continue;

                visited[r][c][d] = true;
                deque.addLast(new int[]{r, c , d});
                dp[r][c] = 1;
            }
        }
    }

    static boolean check(int y, int x){
        if(y < 0 || x < 0 || y >= n || x >= m) return false;
        return true;
    }

    static void count(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dp[i][j] == 1) answer ++;
            }
        }
    }
}
