import java.util.*;

class Solution {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] ry = {0, 1, 0 ,-1};
    static int[] rx = {1, 0, -1, 0};
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new int[n][m];
        for(int i=0; i<n; i++){
            String s = maps[i];
            for(int j=0; j<m; j++){
                char c = s.charAt(j);
                
                if(c != 'X'){
                    map[i][j] = c - '0';
                }
            }
        }
        
        visited = new boolean[n][m];
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j]!= 0){
                    int sum = bfs(i, j);
                    list.add(sum);
                }
                
            }
        }
        
        if(list.size() == 0){
            return new int[]{-1};
        }
        else{
            int[] answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
            
            return answer;        
        }
    
    }
    
    static int bfs(int startY, int startX){
        int answer = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{startY, startX});
        visited[startY][startX] = true;
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            
            answer += map[now[0]][now[1]];
            
            for(int i=0; i<4; i++){
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];
                
                if(r < 0 || c< 0 || r>= n || c>= m) continue;
                
                if(map[r][c] == 0) continue;
                
                if(visited[r][c]) continue;
                
                visited[r][c] = true;
                deque.addLast(new int[]{r, c});
            }
        }
        
        
        return answer;
    }
}