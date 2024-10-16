import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] dist;
    static ArrayDeque<int[]> deque;
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                int num = s.charAt(j) - '0';
                map[i][j] = num;
                dist[i][j] = INF;
            }
        }
        bfs();
        sb.append(dist[n - 1][n - 1]).append("\n");
        System.out.println(sb);

    }


    static void bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });

        boolean[][] visited = new boolean[n][n];
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int nowY = now[0];
            int nowX = now[1];
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r>= n || c >= n) continue;

                if(visited[r][c]) continue;
                visited[r][c] = true;

                if(dist[r][c] > dist[nowY][nowX]){
                    if(map[r][c] == 1){
                        dist[r][c] = dist[nowY][nowX];
                    }else{
                        dist[r][c] =  dist[nowY][nowX] + 1;
                    }

                    pq.add(new int[]{r, c, dist[r][c]});
                }
            }

        }
    }

}