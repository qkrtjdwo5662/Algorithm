import java.util.*;

class Solution {
    static int n;
    static int answer;
    static String[] user_id;
    static String[] banned_id;
    static Set<String> set;
    static List<Set<String>> setList;
    static boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        n = banned_id.length;
        this.user_id = user_id;
        this.banned_id = banned_id;
        set = new HashSet<>();
        setList = new ArrayList<>();
        visited = new boolean[user_id.length];
        
        backtrack(0);
        return setList.size();
    }
    
    static void backtrack(int depth){
        if(depth == n){
            // 해당 set 점검
            if(set.size() == n && checkComb()){
                Set<String> newSet = new HashSet<>();
                
                for(String id : set){
                    newSet.add(id);
                }
                
                setList.add(newSet);
            }
            return;
        }
        
        String ban = banned_id[depth];
        for(int i=0; i<user_id.length; i++){
            if(visited[i]) continue;
            String id = user_id[i];
            boolean flag = true;
            
            if(id.length() == ban.length()){
                
                for(int j=0; j< ban.length(); j++){
                    char c1 = ban.charAt(j);
                    char c2 = id.charAt(j);
                    
                    if(c1 == '*') {
                        continue;
                    } else if(c1 == c2){
                      continue;  
                    } else {
                        flag = false;
                        break;
                    }
                }
            }else continue;
            
            if(flag) {
                set.add(id);
                visited[i] = true;
                backtrack(depth + 1);
                visited[i] = false;
                set.remove(id);
            }
        }
    }
    
    static boolean checkComb(){
        // true 넣어
        // false 넣지마
        
        // 모든 원소가 겹치는 set이 한개라도 있다면 넣지마
        if(setList.size() == 0) return true;
        
        for(int i=0; i<setList.size(); i++){
            Set<String> nowSet = setList.get(i);
            boolean isSame = true;
            
            for(String id : set){
                if(!nowSet.contains(id)){
                    isSame = false;
                    break;
                }
            }
            
            if(isSame) return false;
        }
        
        return true;
    }
}