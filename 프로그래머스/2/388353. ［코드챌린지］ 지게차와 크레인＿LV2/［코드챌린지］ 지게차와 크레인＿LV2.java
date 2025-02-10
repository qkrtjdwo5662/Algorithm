import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        n = storage.length;
        m = storage[0].length();
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        
        for(int i=0; i<n; i++){
            String s = storage[i];
            for(int j=0; j<m; j++){
                int num = s.charAt(j) - 'A' + 1;
                map[i][j] = num;
            }
        }
        
        
        for(int i=0; i< requests.length; i++){ // 100
            String request = requests[i];
            
            char c = request.charAt(0);
            int num = c - 'A' + 1;
            
            if(request.length() == 1){
                jigae(num);
            }else if(request.length() == 2){
                crane(num);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]) answer ++;
            }
        }
    
        
        return answer;
    }
    
    static void jigae(int num){
        List<int[]> list = new ArrayList<>();
        
        // 바깥쪽인지 판단 여부 필요
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isOutSide(i, j) && !visited[i][j] && map[i][j] == num){
                    list.add(new int[]{i, j});
                }
            }
        }
         
        for(int i=0; i<list.size(); i++){
            int[] now = list.get(i);
            
            visited[now[0]][now[1]] = true;
        }
    }
    
    static void crane(int num){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j] == num){
                    visited[i][j] = true;
                }
            }
        }
    }
    
    static boolean isOutSide(int sy, int sx){
        // 해당 지점에서 바깥쪽으로 도달 할수 있나?
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] used = new boolean[n][m];
        used[sy][sx] = true;
        deque.addLast(new int[]{sy, sx});
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            
            for(int i=0; i<4; i++){
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];
                
                if(r < 0 || c < 0 || r >= n || c>= m) return true;                          
                if(used[r][c]) continue;
                
                if(visited[r][c]){
                    used[r][c] = true;
                    deque.addLast(new int[]{r, c});
                }
            }
        }
        
        return false; // 밖으로 탈출 못해
        
    }
}