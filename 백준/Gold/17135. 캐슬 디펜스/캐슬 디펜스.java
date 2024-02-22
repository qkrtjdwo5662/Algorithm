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
    static int d;
    static int[][] board;
    static int[][] copyBoard;
    static boolean[] visited;

    static boolean[][] boardVisit;
    static int[] ry = {0, -1, 0};
    static int[] rx = {-1, 0, 1};
    static ArrayList<int[]> killList;
    static int answer;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m];
        visited = new boolean[m];

        answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        backtrack(0, 0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int depth, int index){
        if(depth == 3){
            // 궁수 3명 세팅
            copyBoard = new int[n][m];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyBoard[i][j] = board[i][j];
                }
            }
            // 궁수가 점점 올라감
            for (int i = n; i > 0 ; i--) {
                killList = new ArrayList<>();
                killEnemy(i);
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i = index; i < m; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    static void killEnemy(int rSize){
        for (int i = 0; i < m; i++) {
            if(visited[i]){
                bfs(new int[]{rSize, i}, rSize);
            }
        }

        for (int i = 0; i < killList.size(); i++) {
            int[] now = killList.get(i);

            if(copyBoard[now[0]][now[1]] == 1){
                copyBoard[now[0]][now[1]] = 0;
                count ++;
            }
        }
    }

    static void bfs(int[] start, int rSize){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boardVisit = new boolean[rSize][m];

        deque.addLast(start);

        int depth = 0;
        int size = 0;
        while(!deque.isEmpty()){
            size = deque.size();
            depth ++;
            for (int i = 0; i < size; i++) {
                int[] now = deque.pollFirst();
                
                for (int j = 0; j < 3; j++) {
                    int r = now[0] + ry[j];
                    int c = now[1] + rx[j];

                    if(r < 0 || c< 0 || r>= rSize || c>=m ) continue;

                    if(!boardVisit[r][c]){
                        if(depth <= d && copyBoard[r][c] == 1) {
                            killList.add(new int[]{r, c});
                            return;
                        }
                        boardVisit[r][c] = true;
                        deque.addLast(new int[]{r, c});
                    }
                }
            }


        }
    }
}