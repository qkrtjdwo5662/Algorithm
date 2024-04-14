import java.util.ArrayDeque;

class Solution {
    static int n;
    static int m;
    static int[][] newBoard;
    static boolean[][][] visited;
    static ArrayDeque<int[]> deque;
    static int[] ry = {0, 0, 1, 0, -1};
    static int[] rx = {0, 1, 0, -1, 0};
    static int solution(String[] board){
        int answer = 0;

        n = board.length;
        m = board[0].length();
        newBoard = new int[n][m];
        visited = new boolean[n][m][5];
        //"R"은 로봇의 처음 위치를, 1
        // "D"는 장애물의 위치를, -1
        // "G"는 목표지점을  2
        deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                if(c == 'R'){
                    deque.addLast(new int[]{i, j, 0, 0});
                    visited[i][j][0] = true;
                }else if(c == 'D'){
                    newBoard[i][j] = -1;
                }else if(c == 'G'){
                    newBoard[i][j] = 2;
                }
            }
        }

        answer = bfs();
        return answer;
    }

    static int bfs(){
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            int y = now[0];
            int x = now[1];
            int direction = now[2];
            int distance = now[3];
//            System.out.println(y + " " + x + " " + direction + " " + distance);
            if(newBoard[y][x] == 2) return distance;
            for (int i = 1; i <= 4; i++) {
                int[] pos = go(now, i);
                int r = pos[0];
                int c = pos[1];

                if( r < 0 || c < 0 || r >= n || c>= m) continue;

                if(newBoard[r][c] == -1) continue;

                if(r == y && c == x) continue;
                
                if(!visited[r][c][i]){
                    visited[r][c][i] = true;
                    deque.addLast(new int[]{r, c, i, distance + 1});
                }
            }
        }

        return -1;
    }

    static int[] go(int[] now, int d){
        int r = now[0];
        int c = now[1];
        int tempR = 0;
        int tempC = 0;
        while(true){
            tempR = r;
            tempC = c;

            r += ry[d];
            c += rx[d];

            if(r < 0 || c < 0 || r >= n || c>= m) return new int[]{ tempR,  tempC };

            if(newBoard[r][c] == -1) return new int[]{ tempR,  tempC };

        }

    
    }
}