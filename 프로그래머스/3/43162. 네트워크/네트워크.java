import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
            
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, computers);
                answer ++;
            }    
        }
        
        return answer;
    }
    static void dfs(int n, int[][] computers){
        if(visited[n]) return;
        visited[n] = true; // 방문처리 하고        
        
        for(int i=0; i<visited.length; i++){
            
            int node = computers[n][i]; // n에서 i로 연결여부
            
            if(node == 1 && !visited[i]){
                dfs(i, computers);
            }
        }
        
    }
}