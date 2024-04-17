class Solution {
    static int answer;
    static String target;
    static String[] words;
    
    static boolean[] visited;
    static int n;
    public int solution(String begin, String target, String[] words) {
        answer = 100;
        n = words.length;
        this.words = words;
        this.target = target;
        visited = new boolean[n];
        
        boolean flag = false;
        for(int i=0; i<words.length; i++){
            String word = words[i];
            
            if(word.equals(target)) flag = true;
        }
        
        if(!flag) return 0;
        
        // dfs(begin, 0, 0);
        backtrack(begin, 0);
        return answer;
    }
    static void backtrack(String now, int count){
        if(now.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(count(now, words[i]) == 1){
                    visited[i] = true;
                    backtrack(words[i], count + 1);
                    visited[i] = false;
                }
            }
        }
    }
    
    
    static void dfs(String now, int depth, int count){
        if(now.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        
        if(depth == n){
            if(now.equals(target)){
                answer = Math.min(answer, count);
            }
            return;
        }
        
        
        if(count(now, words[depth]) == 1){
            dfs(words[depth], depth + 1, count + 1);
            dfs(now, depth + 1, count);
        }else dfs(now, depth + 1, count);
        
    }
    
    static int count(String now, String compareStr){
        int a = 0;
    
        
        for(int i=0; i<now.length(); i++){
            if(now.charAt(i) != compareStr.charAt(i)) a ++;
        }
        
        return a;
    }
}