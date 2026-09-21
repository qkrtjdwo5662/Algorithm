import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<String> list = new ArrayList<>();
        
        long num = n; 
        long mod = 0;
        
        while(num > 0){
            mod = num % 10;
            list.add(String.valueOf(mod));
            
            num /= 10;
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        
        return answer;
    }
}