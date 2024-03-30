import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[][] groupBoard;
    static boolean[][] visited;
    static int[] ry = {1, -1, 0, 0};
    static int[] rx = {0, 0, 1, -1};
    static ArrayDeque<int[]> deque;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        groupBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        visited = new boolean[n][n];
        int groupNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j] != 0){
                    bfs(i,j, ++groupNum);
                }
            }
        }

        ArrayList<int[]>[] groupList = new ArrayList[groupNum + 1];
        for (int i = 1; i <= groupNum ; i++) {
            groupList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(groupBoard[i][j] != 0){
                    int num = groupBoard[i][j];
                    groupList[num].add(new int[]{i, j});
                }
            }
        }

        answer = 987654321;
        for (int i = 1; i <= groupNum ; i++) {
            ArrayList<int[]> list = groupList[i];
            deque = new ArrayDeque<>();
            visited = new boolean[n][n];

            for (int j = 0; j < list.size(); j++) {
                int y = list.get(j)[0];
                int x = list.get(j)[1];
                deque.addLast(new int[]{y, x, 0});
                visited[y][x] = true;
            }
            bfs2(i);

        }
        sb.append(answer).append("\n");
        System.out.println(sb);


    }
    static void bfs2(int num){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(groupBoard[now[0]][now[1]] != 0  && groupBoard[now[0]][now[1]] != num){
                answer = Math.min(answer, now[2] - 1);
            }

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if( r< 0 || c< 0 || r>= n || c>= n) continue;

                if(board[r][c] == num) continue;
                if(visited[r][c]) continue;

                visited[r][c] = true;
                deque.addLast(new int[]{r, c, now[2] + 1});
            }


        }
    }

    static void bfs(int y, int x, int num){

        visited[y][x] = true;
        deque = new ArrayDeque<>();
        deque.addLast(new int[]{y, x});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            groupBoard[now[0]][now[1]] = num;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if( r< 0 || c< 0 || r>= n || c>= n) continue;

                if(board[r][c] == 0) continue;
                if(visited[r][c]) continue;

                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
            }
        }
    }

    static void print(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}