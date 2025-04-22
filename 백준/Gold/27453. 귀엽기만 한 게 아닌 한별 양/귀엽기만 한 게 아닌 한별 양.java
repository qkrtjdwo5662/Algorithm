import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};

    static char[][] map;
    static int n;
    static int m;
    static int k;
    static int d;

    static class Info{
        int ny;
        int nx;
        int by;
        int bx;
        StringBuilder sb;
        int total;
        int d;

        public Info(int ny, int nx, int by, int bx, StringBuilder sb, int total, int d){
            this.ny = ny;
            this.nx = nx;
            this.by = by;
            this.bx = bx;
            this.sb = sb;
            this.total = total;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int startY = -1;
        int startX = -1;
        int endY = -1;
        int endX = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if(c == 'S'){
                    startY = i;
                    startX = j;
                }else if(c == 'H'){
                    endY = i;
                    endX = j;
                }
            }
        }

        sb.append(bfs(startY, startX, endY, endX));
        System.out.println(sb);
    }

    static int bfs(int sy, int sx, int ey, int ex){
        ArrayDeque<Info> deque = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][4];
        visited[sy][sx][0] = true;
        visited[sy][sx][1] = true;
        visited[sy][sx][2] = true;
        visited[sy][sx][3] = true;
        deque.addLast(new Info(sy, sx, -1, -1, new StringBuilder(), 0, 0));

        while(!deque.isEmpty()){
            Info now = deque.pollFirst();

            int ny = now.ny;
            int nx = now.nx;
            int by = now.by;
            int bx = now.bx;
            StringBuilder sb = now.sb;
            int total = now.total;
            int d = now.d;

            for (int i = 0; i < 4; i++) {
                int r = ny + ry[i];
                int c = nx + rx[i];

                if(r < 0 || r >= n || c < 0 || c>= m) continue;

                if(r == ey && c == ex && total <= k) return d + 1;

                if(map[r][c] == 'S' || map[r][c] == 'X') continue;

                if(r == by && c == bx) continue; // 이전에 갔던 곳 안간다

                if(!visited[r][c][i]){

                    String s = sb.toString();
                    String[] split = s.split(" ");
                    int change = 0;
                    StringBuilder newSb = new StringBuilder();

                    for (int j = 0; j < sb.length(); j++) {
                        newSb.append(sb.charAt(j));
                    }
                    if(split.length < 3){
                        if(split.length != 2){
                            newSb.append(map[r][c] - '0').append(" ");
                        }else newSb.append(map[r][c] - '0');
                        change = total + map[r][c] - '0';

                        if(change <= k){
                            visited[r][c][i] = true;
                            deque.addLast(new Info(r, c, ny, nx, newSb, change, d + 1));
                        }


                    }else{
                        change = total - Integer.parseInt(split[0]);
                        change += map[r][c] - '0';

                        if(change <= k) {
                            newSb = new StringBuilder();
                            newSb.append(sb.charAt(2));
                            newSb.append(sb.charAt(3));
                            newSb.append(sb.charAt(4));
                            newSb.append(" ");
                            newSb.append(map[r][c] - '0');
                            visited[r][c][i] = true;
                            deque.addLast(new Info(r, c, ny, nx, newSb, change, d + 1));
                        }
                    }
                }

            }
        }
        return -1;
    }
}
