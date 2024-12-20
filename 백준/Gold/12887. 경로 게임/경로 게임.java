import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        map = new int[2][n];
        int count = 0;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                if(s.charAt(j) == '.'){
                    map[i][j] = 1; // white
                    count ++;
                }
            }

        }
        int answer = 0;
        for (int i = 0; i < 2; i++) {
            if(map[i][0] == 1){
                int result = bfs(i);
                if(result != 0){
                    answer = Math.max(answer, count - bfs(i));
                }
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static int bfs(int startY){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[2][n];
        visited[startY][0] = true;
        deque.addLast(new int[]{startY, 0, 1});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            int y = now[0];
            int x = now[1];
            int d = now[2];

            if(x == n - 1) return d;

            for (int i = 0; i < 4; i++) {
                int r = y + ry[i];
                int c = x + rx[i];

                if(r < 0 || c < 0 || r>= 2 || c>= n) continue;

                if(map[r][c] == 0) continue;

                if(visited[r][c]) continue;

                visited[r][c] = true;
                deque.addLast(new int[]{r, c, d + 1});
            }
        }

        return 0;
    }
}