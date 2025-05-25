import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        solve();
        System.out.println(answer);
    }

    static void solve() {
        for (int y1 = 0; y1 < n; y1++) {
            for (int x1 = 0; x1 < m; x1++) {
                int size1 = 0;
                while (canPlace(y1, x1, size1)) {
                    place(y1, x1, size1, true);
                    int area1 = size1 * 4 + 1;

                    for (int y2 = 0; y2 < n; y2++) {
                        for (int x2 = 0; x2 < m; x2++) {
                            int size2 = 0;
                            while (canPlace(y2, x2, size2)) {
                                int area2 = size2 * 4 + 1;
                                answer = Math.max(answer, area1 * area2);
                                size2++;
                            }
                        }
                    }

                    place(y1, x1, size1, false);
                    size1++;
                }
            }
        }
    }

    static boolean canPlace(int y, int x, int size) {
        if (map[y][x] == '.' || visited[y][x]) return false;
        for (int i = 0; i < 4; i++) {
            for (int d = 1; d <= size; d++) {
                int ny = y + ry[i] * d;
                int nx = x + rx[i] * d;
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) return false;
                if (map[ny][nx] == '.' || visited[ny][nx]) return false;
            }
        }
        return true;
    }

    static void place(int y, int x, int size, boolean flag) {
        visited[y][x] = flag;
        for (int i = 0; i < 4; i++) {
            for (int d = 1; d <= size; d++) {
                int ny = y + ry[i] * d;
                int nx = x + rx[i] * d;
                visited[ny][nx] = flag;
            }
        }
    }
}