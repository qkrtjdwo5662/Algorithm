import java.util.*;
class Solution {
    // . 빈
    // R 처음 위치
    // G 목표 지점
    static int[][] map;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    static int n;
    static int m;
    static boolean[][][] visited;
    static int[] start;
    static int[] end;
    
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        map = new int[n][m];
        start = new int[2];
        end = new int[2];
        for(int i=0; i<n; i++){
            String s = board[i];
            for(int j=0; j<m; j++){
                char c = s.charAt(j);
                if(c == 'R'){
                    map[i][j] = 1;
                    start[0] = i;
                    start[1] = j;
                }else if(c == 'D'){
                    map[i][j] = -1;
                }else if(c == 'G'){
                    map[i][j] = 2;
                    end[0] = i;
                    end[1] = j;
                }
            }    
        }
        
        visited = new boolean[n][m][4];
        answer = bfs(start[0], start[1]);
        if(answer == 0) return -1;
        
        return answer;
    }
    
    static int bfs(int startY ,int startX){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{startY, startX, 0});
        visited[startY][startX][0] = true;
        visited[startY][startX][1] = true;
        visited[startY][startX][2] = true;
        visited[startY][startX][3] = true;
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            int y = now[0];
            int x = now[1];
            int count = now[2];
            
            if(y == end[0] && x == end[1]) return count;
            
            for(int i=0; i<4; i++){
                int[] move = go(y, x, i);
                
                int r = move[0];
                int c = move[1];
                        
                if(visited[r][c][i]) continue;
                visited[r][c][i] = true;
                deque.addLast(new int[]{r, c, count + 1});
                
            }
        }
        
        return 0;
    }
    
    static int[] go(int y, int x, int d){
        while(true){
            int nowY = y;
            int nowX = x;
            
            nowY += ry[d];
            nowX += rx[d];
            
            if(nowY < 0 || nowX < 0 || nowY>= n || nowX>= m) break;
            
            if(map[nowY][nowX] == -1) break;
            y = nowY;
            x = nowX;
        }
        
        return new int[]{y, x};
    }
}