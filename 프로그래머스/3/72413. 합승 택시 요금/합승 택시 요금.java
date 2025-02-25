import java.util.*;

class Solution {
    static int n;
    static int s;
    static int a;
    static int b;
    static List<Node>[] adjList;
    static final int INF = 987654321;
    static class Node{
        int to;
        int weight;
        
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        // 4 -> 6 -> 2
        // 4 -> 2 -> 6
        // 4 -> 6 , 4 -> 2
        this.n = n;
        this.s = s;
        this.a = a;
        this.b = b;
        adjList = new ArrayList[n + 1];
        
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<fares.length; i++){
            int u = fares[i][0];
            int v = fares[i][1];
            int w = fares[i][2];
            
            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }
        
        // S -> X, X -> a, X -> b
        int[] distS = dijkstra(s); // S부터 시작
        int[] distA = dijkstra(a); // A부터 시작
        int[] distB = dijkstra(b); // B부터 시작
        
        for(int i=1; i<= n; i++){
            if(distS[i] == INF || distA[i] == INF || distB[i] == INF) continue;
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }
        
        return answer;
    }
    
    static int[] dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
           return Long.compare(o1.weight, o2.weight); 
        });
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        
        dist[s] = 0;
        pq.add(new Node(s, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            for(int i=0; i<adjList[now.to].size(); i++){
                Node next = adjList[now.to].get(i);
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        return dist;
    }
    
}