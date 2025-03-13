import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[][] map;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};

    static boolean[][] visited;
    static int max;
    static int min;

    static int maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        map = new String[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                String s = st.nextToken();
                map[i][j] = s;
            }
        }

        maxDepth = 2*n - 2;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        visited[0][0] = true;
        backtrack(0, 0, Integer.parseInt(map[0][0]), "", 0);
        visited[0][0] = false;
        sb.append(max).append(" ");
        sb.append(min).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int y, int x, int sum, String s, int depth){
        if(depth > maxDepth) return;

        if(y == n-1 && x == n-1){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int r = y + ry[i];
            int c = x + rx[i];

            if(r < 0 || c < 0 || r>=n || c>=n ) continue;

            if(!visited[r][c]){
                visited[r][c] = true;
                if(map[r][c].equals("*")){
                    backtrack(r, c, sum , "*", depth + 1);
                }else if(map[r][c].equals("-")){
                    backtrack(r, c, sum , "-", depth + 1);
                }else if(map[r][c].equals("+")){
                    backtrack(r, c, sum , "+", depth + 1);
                }else{ // 숫자인 경우
                    if(s.equals("")){
                        backtrack(r, c, Integer.parseInt(map[r][c]) , "", depth + 1);
                    }else{
                        if(s.equals("*")){
                            backtrack(r, c, Integer.parseInt(map[r][c]) * sum, s, depth + 1);
                        }else if(s.equals("-")){
                            backtrack(r, c, sum - Integer.parseInt(map[r][c]), s, depth + 1);
                        }else if(s.equals("+")) {
                            backtrack(r, c, sum + Integer.parseInt(map[r][c]), s, depth + 1);
                        }
                    }
                }
                visited[r][c] = false;
            }
        }
    }
}
