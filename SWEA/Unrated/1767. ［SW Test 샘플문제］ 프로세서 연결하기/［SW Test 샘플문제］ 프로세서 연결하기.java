import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static class Core{
        int y;
        int x;
        public Core(int y, int x){
            this.y = y;
            this.x = x;
        }


    }
    static int n;
    static int[][] board;
    static ArrayList<Core> coreList;
    static boolean[] visited;
    static int answer; // 라인 수
    static int count; // 코어 수
    static int[] ry = {0, 0, 1, -1};
    static int[] rx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= tc ; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            coreList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());

                    if(num == 1 && !side(new int[]{i, j})){
                        coreList.add(new Core(i, j));
                    }

                    board[i][j] = num;

                }
            }
            visited = new boolean[coreList.size()];

            answer = Integer.MAX_VALUE;
            count = 0;
            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static boolean side(int[] now){
        for (int i = 0; i < 4 ; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if( r< 0 || c< 0 || r>= n || c>= n) return true;
        }

        return false;
    }
    static void dfs(int depth, int lineCount, int coreCount){
        if(depth == coreList.size()){
            if(count < coreCount){
                count = coreCount;
                answer = lineCount;
            }else if(count == coreCount){
                answer = Math.min(answer, lineCount);
            }

            return;
        }

        ArrayList<int[]> list = new ArrayList<>();
        if (drawLine(coreList.get(depth), 0, list)) {
            dfs(depth + 1, lineCount + list.size(), coreCount + 1);
        }
        removeLine(list);

        list.clear();
        if (drawLine(coreList.get(depth), 1, list)) {
            dfs(depth + 1, lineCount + list.size(), coreCount + 1);
        }
        removeLine(list);

        list.clear();
        if (drawLine(coreList.get(depth), 2, list)) {
            dfs(depth + 1, lineCount + list.size(), coreCount + 1);
        }
        removeLine(list);

        list.clear();
        if (drawLine(coreList.get(depth), 3, list)) {
            dfs(depth + 1, lineCount + list.size(), coreCount + 1);
        }
        removeLine(list);


        dfs(depth + 1, lineCount, coreCount);

    }

    static boolean drawLine(Core core, int d, ArrayList<int[]> drawList){
        int y = core.y;
        int x = core.x;

        while(true){
            int r = y + ry[d];
            int c = x+  rx[d];

            if(r < 0 || c < 0 || r >= n || c >= n) return true;

            if(board[r][c] == 1 || board[r][c] == 2) return false;

            board[r][c] = 2;
            drawList.add(new int[]{r, c});

            y = r;
            x = c;
        }


    }

    static void removeLine(ArrayList<int[]> drawList){
        for (int i = 0; i < drawList.size(); i++) {
            int[] now = drawList.get(i);

            board[now[0]][now[1]] = 0;
        }

    }
}