import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] map;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};

    static Set<Character> door;
    static Set<Character> key;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        int startY = -1;
        int startX = -1;

        key = new HashSet<>();
        door = new HashSet<>();

        key.add('a');
        key.add('b');
        key.add('c');
        key.add('d');
        key.add('e');
        key.add('f');

        door.add('A');
        door.add('B');
        door.add('C');
        door.add('D');
        door.add('E');
        door.add('F');

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);

                map[i][j] = c;

                if(c == '0'){
                    startY = i;
                    startX = j;
                }
            }
        }

        int answer = bfs(startY, startX);
        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static int bfs(int y, int x){
        boolean[][][] visited = new boolean[n][m][64];
        visited[y][x][0] = true;
        map[y][x] = '.';
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] {y, x, 0, 0});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            int ny = now[0];
            int nx = now[1];
            int d = now[2];
            int info = now[3];

//            System.out.println(ny + " " + nx + " " + info);
            if(map[ny][nx] == '1') return d;

            for (int i = 0; i < 4; i++) {
                int r = ny + ry[i];
                int c = nx + rx[i];

                if(r < 0 || c < 0 || r >= n || c >= m) continue;

                if(map[r][c] == '#') continue;

                if(visited[r][c][info]) continue;

                if(door.contains(map[r][c])){
                    if((info & (1 << (map[r][c] - 'A'))) == (1 << (map[r][c] - 'A'))){ // 해당 열쇠 가지고 있는지 info and (1 << bit)
                        visited[r][c][info] = true;
                        deque.addLast(new int[]{r, c, d + 1, info});
                    }
                }

                if(key.contains(map[r][c])){
//                    info = info | 1 << (map[r][c] - 'a'); // 열쇠를 가지게 됨
                    deque.addLast(new int[]{r, c, d + 1, info | 1 << (map[r][c] - 'a')});
                    visited[r][c][info | 1 << (map[r][c] - 'a')] = true;
                }

                if(map[r][c] == '.' || map[r][c] == '1'){
                    visited[r][c][info] = true;
                    deque.addLast(new int[]{r, c, d + 1, info});
                }


            }
        }

        return -1;
    }

}
