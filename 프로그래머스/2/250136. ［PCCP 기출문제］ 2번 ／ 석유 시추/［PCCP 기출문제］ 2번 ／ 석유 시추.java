import java.util.*;

class Solution {
    static int[][] land; // 1일때 석유 존재
    static int[][] map; // 영역 표시 
    static int[][] count; // 덩어리 count
    
    static int num;
    
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    static int n;
    static int m;
    static boolean[][] visited;
    public int solution(int[][] land) {
        this.land = land;
        
        n = land.length;
        m = land[0].length;
        
        num = 1;
        map = new int[n][m];
        count = new int[n][m];
        visited = new boolean[n][m];
        int answer = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && land[i][j] == 1)
                
                bfs(i, j);
            }
        }
        
        for(int i=0; i<m; i++){
            Set<Integer> set = new HashSet<>();
            int total = 0;
            
            for(int j=0; j<n; j++){
                if(!set.contains(map[j][i])){
                    set.add(map[j][i]);
                    total += count[j][i];
                }
            }
            
            answer = Math.max(answer, total);
           
        }
        
        return answer;
    }
    
    static void bfs(int startY, int startX){
        int answer = 0;
        
        ArrayList<int[]> bfsList = new ArrayList<>();
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        bfsList.add(new int[]{startY, startX});
        deque.addLast(new int[]{startY, startX});
        
        visited[startY][startX] = true;
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            answer += land[now[0]][now[1]];
            
            for(int i=0; i<4; i++){
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];
                
                if(r < 0 || c < 0 || r >= n || c >= m) continue;
                
                if(land[r][c] == 0) continue;
                
                if(visited[r][c]) continue;
                
                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
                bfsList.add(new int[]{r, c});
            }
        }
        
        for(int i=0; i<bfsList.size(); i++){
            int[] now = bfsList.get(i);
            
            map[now[0]][now[1]] = num;
            count[now[0]][now[1]] = answer;
        }
        
        num++;
    }
}