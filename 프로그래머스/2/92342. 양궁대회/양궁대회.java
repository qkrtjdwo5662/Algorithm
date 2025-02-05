import java.util.*;

class Solution {
    static int[] info;
    static int[] answer;
    static int max = 0;
    static int minScore = 11;
    
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        this.info = info; // 어피치
        
        backtrack(0, n, new int[11], 10);
        if(minScore == 11){
           return new int[]{-1}; 
        }
        return answer;
    }
    
    static void backtrack(int depth, int n, int[] lion, int min){
        if(depth == n){
            int diff = calScore(lion);
            
            if(diff >= max ){ // 갱신되고
                if(minScore > min){ // 갱신되면
                    max = diff;
                    minScore = min;
                    
                    for(int i=0; i<11; i++){
                        answer[i] = lion[i];
                    }
                    
                }
            }
        
            
            return;
        }
        
        for(int i=0; i < 11; i++){
            if(lion[i] <= info[i]){ // 작거나 같은 곳만 ++
                lion[i] ++;
                backtrack(depth + 1, n, lion, Math.min(min, 10 - i));
                lion[i] --;
            }
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