import java.util.*;

class Solution {
    static int[] info;
    static int n;
    static List<Integer>[] adjList;
    static int answer;
    static boolean[] visited;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        n = info.length;
        adjList = new List[n];
        visited = new boolean[n];
        this.info = info;
        
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        visited[0] = true;
        go(1, 0);
        
        return answer;
    }
    
    static void go(int sheep, int wolf){
        if(sheep <= wolf){
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        // if(count == n) return;
        
        for(int i=0; i<n; i++){
            if(visited[i]){ // 방문 했다면 
                // 자식 노드 탐색
                for(int j=0; j< adjList[i].size(); j++){
                    int next = adjList[i].get(j);
                    if(!visited[next]){
                        visited[next] = true;
                                                
                        
                        if(info[next] == 0){
                            go(sheep + 1, wolf);
                        }else{
                            go(sheep, wolf + 1);
                        }
                        
                        visited[next] = false;
                    }
                }
            }
            
        }
    }
    
}