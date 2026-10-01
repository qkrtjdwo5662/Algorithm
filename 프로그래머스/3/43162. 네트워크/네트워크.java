import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // u-f 부모 최신화
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            set.add(find(i));
        }
        return set.size();
    }
    
    static void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);
    
        if(p1 <= p2){
            parent[p2] = p1;    
        }else parent[p1] = p2;
        
    }
    
    static int find(int a){
        if(parent[a] == a){
            return parent[a];
        }
        return parent[a] = find(parent[a]);
    }
}