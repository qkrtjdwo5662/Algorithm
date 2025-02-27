import java.util.*;

class Solution {
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    static final int INF = 987654321;
    static int[][] board;
    static int n;
    public int solution(int[][] board) {
        int answer = 0;
        this.board = board;
        this.n = board.length;
        
        answer = dijkstra();
        return answer;
    }
    
    static int dijkstra(){
        int[][][] cost = new int[n][n][4];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    cost[i][j][k] = INF;    
                }
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[3], o2[3]);
        });
        
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;
        pq.add(new int[]{0, 0, 0, 0});
        pq.add(new int[]{0, 0, 1, 0});
    
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            int ny = now[0];
            int nx = now[1];
            int nd = now[2];
            int nw = now[3];
            
            
            for(int i=0; i<4; i++){
                int r = ny + ry[i];
                int c = nx + rx[i];
                
                if(r < 0 || c < 0 || r>= n || c>= n) continue;
                
                if(board[r][c] == 1) continue;
                
                if(i == nd){
                    if(cost[r][c][i] > cost[ny][nx][nd] + 100){
                        cost[r][c][i] = cost[ny][nx][nd] + 100;
                        pq.add(new int[]{r, c, i, cost[r][c][i]});
                    }
                }else{
                    if(cost[r][c][i] > cost[ny][nx][nd] + 600){
                        cost[r][c][i] = cost[ny][nx][nd] + 600;
                        pq.add(new int[]{r, c, i, cost[r][c][i]});
                    }
                }
            }
        }
        
        int min = INF;
        
        for(int i=0; i<4; i++){
            min = Math.min(min, cost[n-1][n-1][i]);
        }
        
        return min;
    }
}