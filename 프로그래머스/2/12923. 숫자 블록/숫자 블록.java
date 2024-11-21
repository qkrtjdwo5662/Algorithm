import java.util.*;

class Solution {
    static final int MAX = 10_000_000;
    
    public int[] solution(long begin, long end) {
        int s = (int)begin;
        int e = (int)end;

        int[] answer = new int[e - s + 1];
        for (int i = s; i <= e; i++) {
            answer[i - s] = check(i);
        }

        return answer;
    }
    
    static int check(int num){
        int result = 1;
        if(num == 1) return 0;
        else if(num == 2 || num == 3) return 1;
        
        for(int i=2; i<= (int)Math.sqrt(num); i++){ 
            if(num%i == 0) {
                if(num / i <= MAX){
                    return num/i;    
                }else result = Math.max(result, i);
                
            }
        }
        
        return result;
    }
    
}