import java.util.*;

class Solution {
    static String[] maps;
    static int n;
    static int m;
    static int[][] info;
    
    static boolean[][] visited;
    
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    static PriorityQueue<Integer> pq;
    
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        this.maps = maps;
        
        info = new int[n][m];
        
        // pq test
        pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1, o2);
        });
        for(int i=0; i<n; i++){
            String s = maps[i];
            for(int j=0; j<m; j++){
                if(s.charAt(j) != 'X'){
                    info[i][j] = s.charAt(j) - '0';    
                }
            }
        }
        
        //System.out.println(Arrays.deepToString(info));
        
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(info[i][j] != 0 && !visited[i][j]){ // X아니고 방문안했으면 ㄱ
                   bfs(i, j); 
                }
            }
        }
        
        if(pq.size() == 0) return new int[]{-1};
        int[] answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()){
            answer[index ++] = pq.poll();
        }
        
        
        
        return answer;
    }
    
    static void bfs(int y, int x){
        //System.out.println(y + " " + x);
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int num = 0;
        deque.addLast(new int[]{y, x});
        visited[y][x] = true;
        
        num += info[y][x];
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            
            int r = now[0];
            int c = now[1];
            for(int i=0; i<4; i++){
                int nr = r + dy[i];
                int nc = c + dx[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                
                if(info[nr][nc] == 0) continue;
                
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    deque.addLast(new int[]{nr, nc});
                    
                    num += info[nr][nc];
                }
            }
        }
        
        pq.add(num);
        //System.out.println(num);
    }
}