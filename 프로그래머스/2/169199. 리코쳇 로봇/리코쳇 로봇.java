import java.util.*;

class Solution {
    static int[][] info;
    static int n;
    static int m;
    static int[] pos;
    static int[] target;
    
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    static int[][] distance;
    public int solution(String[] board) {
        // 시작 위치에서 출발해서 목표위치까지 최소 몇번 이동?
        // 이동하면서 몇번 이동했는지도 같이 기록
        // 한번 이동하기 시작하면 쭉 이동
        
        n = board.length;
        m = board[0].length();
        
        info = new int[n][m];
        distance = new int[n][m];
        pos = new int[2];
        target = new int[2];
        
        for(int i=0; i<n; i++){
            String s = board[i];
            for(int j=0; j<m; j++){
                distance[i][j] = Integer.MAX_VALUE;
                char c = s.charAt(j);
                
                if(c == '.'){
                    continue;
                }
                else if(c == 'D'){ // 장애물
                    info[i][j] = -1;
                }
                else if(c == 'R'){ // 초기 위치
                    pos[0] = i;
                    pos[1] = j;
                }
                else if(c == 'G'){ // 목표지점
                    info[i][j] = 10;
                }
                
            }
        }
        
        // test
        // go(0, 0, 1); // [2, 0] 
        // go(2, 0, 0); // [2, 3]
        
        //System.out.println(Arrays.deepToString(distance));
        int answer = bfs(pos[0], pos[1]);
        
        //System.out.println(Arrays.deepToString(distance));
        return answer;
    }
    
    static int bfs(int y, int x){
        int answer = 0;
    
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        (o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.add(new int[]{y, x, 0});
        distance[y][x] = 0;
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            int r = now[0];
            int c = now[1];
            int d = now[2];
            
            if(info[r][c] == 10) return d;
            
            for(int i=0; i<4; i++){
                int[] next = go(r, c, i);
                
                int nr = next[0];
                int nc = next[1];
                
                if(d + 1 < distance[nr][nc]){
                    distance[nr][nc] = d + 1;
                    pq.add(new int[] {nr, nc, d + 1});
                }
            }
        }
        return -1;
    }
    
    static int[] go(int y, int x, int d){
        // 현재 위치에서 장애물이나 벽에 부딪힐때까지 이동
        int[] result = new int[2];
        
        int ny = y;
        int nx = x;
        
        result[0] = y;
        result[1] = x;
        
        while(true){
            ny = ny + dy[d];
            nx = nx + dx[d];
            
            if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                // 넘치면
                break;
            }
            
            if(info[ny][nx] == -1){
                // 장애물 만나면
                break;
            }
            
            result[0] = ny;
            result[1] = nx;
        }
        
        //System.out.println(Arrays.toString(result));
        return result;
    }
}