import java.util.*;

class Solution {
    static int[] parent;
    static List<Node>[] adjList;
    static int n;
    static class Node{
        int to;
        int weight;
        
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // mst 
        this.n = n;
        parent = new int[n];
        adjList = new List[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<costs.length; i++){
            int u = costs[i][0];
            int v = costs[i][1];
            int w = costs[i][2];
            
            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }
        
        answer = dijkstra();
        return answer;
    }
    
    static int dijkstra(){
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });
        pq.add(new Node(0, 0));
        
        boolean[] visited = new boolean[n];
        
        int total = 0;
        int count = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.to]) continue;
            visited[now.to] = true;
            
            // System.out.println(now.to + " " + now.weight);
            count ++;
            total += now.weight;
            
            if(count == n) return total;
            
            for(int i=0; i<adjList[now.to].size(); i++){
                Node next = adjList[now.to].get(i);
                if(!visited[next.to]){
                    pq.add(new Node(next.to, next.weight));
                }
            }
        }
        
        return -1;
    }

}