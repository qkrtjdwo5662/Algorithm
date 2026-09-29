import java.util.*;

class Solution {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    static int n;
    static int m;
    static int[][] maps;
    static boolean[][] visited;
    static int[][] dist;
    public int solution(int[][] maps) {
        this.maps = maps;
        
        n = maps.length;
        m = maps[0].length;
        
        // 1이면 이동가능
        // 0, 0 -> n-1, m-1 최단경로 구하기
        
        int answer = bfs();
        return answer;
    }
    static int bfs(){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        
        visited = new boolean[n][m];
        dist = new int[n][m];
        
        visited[0][0] = true;
        dist[0][0] = 1; 
        deque.addLast(new int[]{0, 0});
        
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            
            int y = now[0];
            int x = now[1];
            
            if(y == n - 1 && x == m - 1) return dist[n-1][m - 1];
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                
                if(maps[ny][nx] != 1) continue;
                
                if(!visited[ny][nx]){
                    visited[ny][nx] = true;
                    deque.addLast(new int[]{ny, nx});
                    dist[ny][nx] = dist[y][x] + 1;
                }
            }
        }
        
        return -1;
    }
}