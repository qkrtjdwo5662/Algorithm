import java.util.*;

class Solution {
    static int[] info;
    static int[] answer;
    static int max = -1;
    
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        this.info = info; // 어피치
        
        backtrack(0, n, new int[11]);
        
        if(max == -1){
           return new int[]{-1}; 
        }
        
        return answer;
    }
    
    static void backtrack(int depth, int n, int[] lion){
        if(depth == n){
            int diff = calScore(lion);
            
            if(diff > 0 && diff >= max){ // 갱신되고
                max = diff;
                answer = lion.clone();
            }
        
            return;
        }
        
        for(int i=0; i < 11 && lion[i] <= info[i]; i++){
            lion[i] ++;
            backtrack(depth + 1, n, lion);
            lion[i] --;
        }
    }
    
    static int calScore(int[] lion){
        int a = 0;
        int b = 0;
        
        for(int i=0; i<11; i++){
            if(info[i] >= lion[i] && info[i] > 0) a += (10 - i);
            else if(lion[i] > 0) b += (10 - i);
        }
         
        return b - a;
    }
}