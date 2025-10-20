import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] start;
    static int[] end;
    static int[][] map;

    static List<int[]> gList;

    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};

    static final int MAX = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        start = new int[2];
        end = new int[2];

        gList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);

                if(c == 'g'){
                    gList.add(new int[]{i, j});
                    map[i][j] = -1;
                }else if(c == 'S'){
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = 1;
                }else if(c == 'F'){
                    end[0] = i;
                    end[1] = j;
                    map[i][j] = 2;
                }
            }
        }

        int[] answer = dijkstra();

        System.out.println(answer[0] + " " + answer[1]);

    }

    static int[] dijkstra(){
        // 시작에서 끝점가는데 최소비용(쓰레기, 쓰레기 주변 최소)

        int[][] garbage = new int[n][m];
        int[][] near = new int[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);
            else return Integer.compare(o1[3], o2[3]);
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                garbage[i][j] = MAX;
                near[i][j] = MAX;
            }
        }
        pq.add(new int[]{start[0], start[1], 0, 0});
        garbage[start[0]][start[1]] = 0;
        near[start[0]][start[1]] = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int ny = now[0];
            int nx = now[1];
            int nfrom = now[2];
            int nnear = now[3];

            if(ny == end[0] && nx == end[1]) {
                return new int[]{nfrom, nnear};
            }

            for (int i = 0; i < 4; i++) {
                int dy = ny + ry[i];
                int dx = nx + rx[i];
                int addFrom = 0;
                int addNear = 0;

                if(dy < 0 || dx < 0 || dy >= n || dx >= m ) continue;

                if(map[dy][dx] == -1) addFrom ++; // 쓰레기 거쳐서 가는건지

                if(check(dy, dx)) addNear ++;

                int newFrom = nfrom + addFrom;
                int newNear = nnear + addNear;
                if (newFrom < garbage[dy][dx] ||
                        (newFrom == garbage[dy][dx] && newNear < near[dy][dx])
                ) {

                    garbage[dy][dx] = newFrom;
                    near[dy][dx] = newNear;
                    pq.add(new int[]{dy, dx, newFrom, newNear});
                }
            }
        }

        return new int[]{garbage[end[0]][end[1]], near[end[0]][end[1]]};
    }

    static boolean check(int y, int x){
        if(map[y][x] != 0) return false;

        for (int i = 0; i < 4; i++) {
            int dy = y + ry[i];
            int dx = x + rx[i];

            if(dy < 0 || dx < 0 || dy >= n || dx >= m) continue;

            if(map[dy][dx] == -1) return true;
        }

        return false;
    }
}
