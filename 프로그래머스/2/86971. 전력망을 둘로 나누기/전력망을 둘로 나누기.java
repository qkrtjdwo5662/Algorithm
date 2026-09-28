import java.util.*;

class Solution {
    static ArrayList<Integer>[] adjList;
    static int[][] wires;
    static int n;
    
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        this.wires = wires; 
        this.n = n;


        setTree();
        //System.out.println(adjList);
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            int num1 = bfs(a, b);
            int num2 = bfs(b, a);
            
            adjList[a].add(b);
            adjList[b].add(a);
            
            answer = Math.min((int)Math.abs(num1 - num2), answer);
        }
        
        return answer;
    }
    static int bfs(int a, int b){
        adjList[a].remove(Integer.valueOf(b));
    
        ArrayDeque<Integer> deque = new ArrayDeque<>();
            
        visited = new boolean[n + 1];
        
        visited[a] = true;
        deque.addLast(a);
        int count = 1;
        
        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            
            int len = adjList[now].size();
            for(int i=0; i<len; i++){
                int next = adjList[now].get(i);
                
                if(!visited[next]){
                    deque.addLast(next);
                    visited[next] = true;
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    
    static void setTree(){
        adjList = new ArrayList[n + 1];
        
        for(int i=1; i<= n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        int len = wires.length;
        for(int i=0; i < len; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            // 양방향
            adjList[u].add(v);
            adjList[v].add(u);
            
        }
    }
}
