import java.util.*;

class Solution {
    static int[] answer;
    static int[][] board;
    static boolean[][] visited;
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    static int m;
    static int n;
    public int[] solution(int m, int n, int[][] picture) {
        answer = new int[2];
        board = picture;
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] != 0 && !visited[i][j]){
                    bfs(i, j);
                    count ++;
                }
            }
        }
        answer[0] = count;
        return answer;
    }
    
    static void bfs(int y, int x){
        int num = board[y][x];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{y, x});
        visited[y][x] = true;
        int count = 0;
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            count ++;
            for(int i=0; i<4; i++){
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];
                
                if(r < 0 || c< 0 || r >= m || c>= n) continue;
                
                if(board[r][c] != num) continue;
                
                if(visited[r][c]) continue;
                
                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
            }
        }
        
        answer[1] = Math.max(answer[1], count);
    }
}