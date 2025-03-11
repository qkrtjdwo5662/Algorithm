import java.util.*;

class Solution {
    
    public String solution(String p) {
        String answer = "";
        // 1. 빈문자열 인 경우 빈문자열 반환
        
        // 2. 균형잡힌 괄호 문자열로 분리 u, v
        // 여기서 u는 최소 균형잡힌 문자열, v는 빈 문자열 가능
        
        // 3. u가 올바른 문자열이라면 v 1~2
        
        // 4. u가 올바른 문자열이 아니라면
        answer = divide(p);
        return answer;
    }
    
    static boolean check(String s) {
        // 올바른 괄호 판단
        ArrayDeque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( c == '('){
                deque.addLast(c);
            }else {
                if(deque.isEmpty()) return false;
                deque.pollLast();
            }
        }
        
        if(!deque.isEmpty()) return false;
        return true;
    }
    
    static String divide(String s){
        if(s.equals("")) return "";
        
        String[] answer = new String[2];
        
        int open = 0;
        int close = 0;
        int index = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(') open ++;
            else close ++;
            
            if(open != 0 && open == close){
                index = i;
                break;
            }
        }
        
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        for(int i=0; i<= index; i++){
            char c = s.charAt(i);
            
            u.append(c);
        }
        
        if(index < s.length() - 1){
            for(int i=index + 1; i<s.length(); i++){
                char c = s.charAt(i);
                
                v.append(c);
            }
        }
        
        
        answer[0] = u.toString();
        answer[1] = v.toString();
        
        if(check(answer[0])){
            return answer[0] + divide(answer[1]);
        }else{
            return go(answer[0], answer[1]);
        }
        
        
    }
    
    static String go(String u, String v){
        StringBuilder answer = new StringBuilder();
        
        answer.append('(');
        // 1단계부터 수행한 v 붙이기
        answer.append(divide(v));
        
        answer.append(')');
        
        for(int i=1; i<u.length() - 1; i++){
            if(u.charAt(i) == '(') answer.append(')');
            else answer.append('(');
        }
        
        return answer.toString();
    }
    
}