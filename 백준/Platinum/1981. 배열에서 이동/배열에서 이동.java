import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        board = new int[n + 1][n + 1];
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n ; j++) {
                int num = Integer.parseInt(st.nextToken());

                max = Math.max(max, num);
                min = Math.min(min, num);
                board[i][j] = num;
            }
        }

        int left = 0;
        int right = max - min;
        int answer = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;

            boolean flag = false;
            for (int i = min; i <= max ; i++) {
                if(i <= board[1][1] && board[1][1] <= i + mid){
                    if(bfs(i, i + mid)){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                 answer = Math.min(answer, mid);
                 right = mid - 1;
            }else left = mid + 1;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static boolean bfs(int start, int end){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        deque.addLast(new int[]{1, 1});
        visited[1][1] = true;

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(now[0] == n && now[1] == n) return true;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <= 0 || c <= 0 || r > n || c > n) continue;
                if(start <= board[r][c] && board[r][c] <= end && !visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[] {r, c});
                }
            }
        }

        return false;
    }
}