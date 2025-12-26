import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] newArr;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] original = new int[n][m * 3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    original[i][j * 3 + k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        newArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int total = 0;
                for (int k = 0; k < 3; k++) {
                    total += original[i][j * 3 + k];
                }

                if(total >= t*3) newArr[i][j] = 255;
                else newArr[i][j] = 0;
            }
        }
        int answer = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && newArr[i][j] >= 255){
                    visited[i][j] = true;
                    bfs(i, j);
                    answer ++;
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int y, int x){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{y, x});

        while (!deque.isEmpty()){
            int[] poll = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int ry = poll[0] + dy[i];
                int rx = poll[1] + dx[i];

                if(ry < 0 || ry >= n || rx < 0 || rx >= m) continue;
                
                if(newArr[ry][rx] < 255) continue;

                if(!visited[ry][rx]){
                    visited[ry][rx] = true;
                    deque.addLast(new int[]{ry, rx});
                }
            }
        }
    }
}
