import java.util.*;

class Solution {
    static HashSet<String> set;
    static int answer;
    static boolean[] visited;
    
    static String begin;
    static String target;
    static String[] words;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        this.target = target;
        this.begin = begin;
        this.words = words;
        
        set = new HashSet();
        
        for(int i=0; i<words.length; i++){
            set.add(words[i]);
        }
        
        if(!set.contains(target)) return 0; // 안될거 같으면 버려
        
        for(int i=0; i<words.length; i++){
            if(diff(words[i], begin) == 1){
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }
        }
        
        return answer;
    }
    
    static void dfs(int n, int count){
        if(words[n].equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i] && diff(words[n], words[i]) == 1){
                // 방문하지 않았고, 차이가 1만큼 나면 돌려
                visited[i] = true;
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
    }
    
    static int diff(String s1, String s2){
        int count = 0;
        
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count ++;
        }
        
        return count;
    }
}