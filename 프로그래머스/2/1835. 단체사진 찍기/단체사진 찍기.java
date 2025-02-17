import java.util.*;
class Solution {
    static final int len = 8;
    static boolean[] visited;
    static char[] arr;
    static int n;
    static String[] data;
    static char[] select;
    static int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        this.n = n;
        this.data = data;
        init();
        backtrack(0);
        
        return answer;
    }
    static void init(){
        arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[len];
        select = new char[len];
    }
    static void backtrack(int depth){
        if(depth == len){
            if(check()) answer ++;
            return;
        }
        
        for(int i=0; i<len; i++){
            if(!visited[i]){
                visited[i] = true;
                select[depth] = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    static boolean check(){
        Map<Character, Integer> map = new HashMap<>();
        // 각 문자열마다의 인덱스
        for(int i=0; i<len; i++){
            map.put(select[i], i);
        }
        
        for(int i=0; i<n; i++){
            String s = data[i];
            char first = s.charAt(0);
            char second = s.charAt(2);
            
            int diff = Math.abs(map.get(first) - map.get(second)) - 1;
            
            int targetNum = s.charAt(4) - '0';
            
            if(s.charAt(3) == '='){
                if(targetNum != diff) return false; 
            }else if(s.charAt(3) == '<'){
                if(diff >= targetNum) return false;
            }else if(s.charAt(3) == '>'){
                if(diff <= targetNum) return false;
            }
            
            
        }
        
        return true;
    }
}