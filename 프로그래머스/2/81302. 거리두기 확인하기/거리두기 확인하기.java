import java.util.*;

class Solution {
    static final int N = 5;
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[N];
        
        // 1. 각 응시자마다 다른 응시자와의 거리
        // 2. 각 강의실마다 잘 지켜지는가?
        for(int i=0; i<N; i++){
            // 각 강의실 탐색
            if(bfs(places[i])){
                answer[i] = 1;
            }
            
        }
        
        return answer;
    }
    
    static boolean bfs(String[] place){
        // O : 0
        // P : 1
        // X : -1
        
        int[][] map = new int[N][N];
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            String s = place[i];
            for(int j=0; j<N; j++){
                if(s.charAt(j) == 'P'){
                    map[i][j] = 1;
                    list.add(new int[]{i, j});
                }else if(s.charAt(j) == 'X'){
                    map[i][j] = -1;
                }
            }
        }
        
        int size = list.size();
        
        for(int i = 0; i < size - 1; i ++){
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];
            int[][] distance = new int[N][N];
            int[] start = list.get(i);
            deque.addLast(start);
            visited[start[0]][start[1]] = true;
            
            while(!deque.isEmpty()){
                int[] now = deque.pollFirst();
                int ny = now[0];
                int nx = now[1];
                
                for(int j=0; j<4; j++){
                    
                    int r = ny + ry[j];
                    int c = nx + rx[j];
                    
                    if(r < 0 ||  c < 0 || r >= N || c >= N) continue;
                    
                    if(map[r][c] == -1) continue;
                    
                    if(visited[r][c]) continue;
                    
                    visited[r][c] = true;
                    deque.addLast(new int[]{r, c});
                    distance[r][c] = distance[ny][nx] + 1;
                }
            }
            
            for(int j= i + 1; j < size; j++){
                int[] target = list.get(j);
                // System.out.println(target[0] + " " + target[1] + " " + distance[target[0]][target[1]]);
                if(distance[target[0]][target[1]] > 0 && distance[target[0]][target[1]] <= 2) return false;
            }
        }
        
        return true;
    }
}