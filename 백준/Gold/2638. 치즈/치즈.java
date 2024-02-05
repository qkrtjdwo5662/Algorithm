import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] ry = {1, 0 , -1, 0};
    static int[] rx = {0, 1, 0, -1};
    static ArrayList<int[]> list;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }


        int answer = 0;


        while(true) {
            list = new ArrayList<>();
            isOut();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == 1 && isMelt(new int[]{i, j})) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            if(list.size() == 0) {
                break;
            }else {
                for (int i = 0; i < list.size(); i++) {
                    int[] now = list.get(i);
                    board[now[0]][now[1]] = 0;
                }
            }

            answer++;

        }
        sb.append(answer).append("\n");
        System.out.println(sb);

    }
    public static boolean isMelt(int[] now) {
        int count = 0; // 바깥쪽 접하는 공기 count

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c<0 || r>= n || c>= m ) continue;

            if(board[r][c] == -1) {
                count++;
            }

            if(count == 2) {
                return true;
            }
        }

        return false;

    }

    public static void isOut() {
        ArrayDeque<int[]> deque2 = new ArrayDeque<>();
        deque2.addLast(new int[]{0, 0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        board[0][0] = -1;

        while(!deque2.isEmpty()) {
            int[] now = deque2.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c<0 || r>= n || c>= m) continue;

                if(board[r][c] == 1) continue;

                if(!visited[r][c]) {
                    visited[r][c] = true;
                    deque2.addLast(new int[] {r, c});
                    board[r][c] = -1;
                }

            }
        }

    }

}