import java.util.*;

class Solution {
    static int answer;
    static int n;
    static boolean[] visited;
    
    static Set<String> candidateKey;
    
    static boolean[] keyUsed;
    
    static boolean flag;
    
    static String[][] relation;
    public int solution(String[][] relation) {
        answer = 0;
        n = relation[0].length;
        visited = new boolean[n];
        candidateKey = new HashSet<>();
        this.relation = relation;
        // 1. 컬럼 인덱스 조합
        // 2. 키 조합 그전에 있던 조합?
        // 3. 유일 데이터 가능?
        
        for(int i=1; i<=n; i++){
            dfs(n, 0, 0, i);
        }
        
        // System.out.println(candidateKey);
        return candidateKey.size();
    }
    
    static void dfs(int n, int depth, int count, int maxCount){
        if(depth == n){
            if(count == maxCount){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=0; i<n; i++){
                    if(visited[i]) list.add(i); // 인덱스 넣어줘
                }
                
                
                if(checkData(list) && checkKey(maxCount, list)){
                    
                    StringBuilder sb = new StringBuilder();
                    for(int i=0; i<n; i++){
                        if(visited[i]) sb.append(i).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    candidateKey.add(sb.toString());
                }
                
                
            }
            return;
        }
        
        visited[depth] = true;
        dfs(n, depth + 1, count + 1, maxCount);
        visited[depth] = false;
        dfs(n, depth + 1, count, maxCount);
    }
    
    static boolean checkKey(int size, ArrayList<Integer> list){
        // key 조합이 그전에 있었나?
        flag = false;
        keyUsed = new boolean[size];
        
        for(int i=1; i<= size; i++){
            keyCombine(size, 0, 0, i, "", list);
            
            if(flag) break;
        }
        
        if(flag) return false;
        return true;
        
    }
    
    static void keyCombine(int n, int depth, int count, int maxCount, String s, ArrayList<Integer> list){
        if(flag) return;
        
        if(depth == n){
            
            if(count == maxCount){
                
                if(candidateKey.contains(s)){
                    // 이미 쓴 조합임
                    // System.out.println(s);
                    flag = true; 
                }
                
                
            }
            return;
        }
        
        keyUsed[depth] = true;
        if(count == 0) keyCombine(n, depth + 1, count + 1, maxCount, s + list.get(depth), list);
        else keyCombine(n, depth + 1, count + 1, maxCount, s + " " + list.get(depth), list);
        keyUsed[depth] = false;
        keyCombine(n, depth + 1, count, maxCount, s, list);
    }
    
    static boolean checkData(ArrayList<Integer> list){
        Set<String> data = new HashSet<>();
        
        for(int i=0; i<relation.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<list.size(); j++){
                int index = list.get(j);
                sb.append(relation[i][index]);                
            }
            data.add(sb.toString());
        }
        
        if(data.size() != relation.length) return false;
        return true;
    }
}