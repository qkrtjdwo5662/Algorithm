import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};

    static boolean[][] visited;
    static ArrayDeque<int[]> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 채굴기는 공기와 맞닿아 있는 광물 하나를 골라 채굴가능
        // 원하는 광물의 수 K 이상을 채굴할 수 있는 최소의 D를 구해라

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        int left = 1;
        int right = 1_000_000;

        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            // 공기와 맞닿아 있는 부분부터 bfs
            // 위
            visited = new boolean[n][m];
            deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if(!visited[i][0] && map[i][0] <= mid){
                    visited[i][0] = true;
                    deque.addLast(new int[]{i, 0});
                }

                if(!visited[i][m-1] && map[i][m-1] <= mid){
                    visited[i][m- 1] = true;
                    deque.addLast(new int[]{i, m - 1});
                }
            }

            for (int i = 1; i < m - 1; i++) {
                if(!visited[0][i] && map[0][i] <= mid){
                    visited[0][i] = true;
                    deque.addLast(new int[]{0, i});
                }
            }

            
            int count = bfs(mid);
            if(count >= k){
                answer = mid;
                right = mid - 1;
            }else left = mid  + 1;

        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
    static int bfs(int limit){
        int count = 0;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            count ++;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || r >= n || c < 0 || c >= m) continue;

                if(map[r][c] > limit) continue;

                if(visited[r][c]) continue;
                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
            }
        }

        return count;
    }
}
