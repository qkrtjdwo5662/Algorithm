import java.util.*;

class Solution {
    static String[] arr = {"4", "1", "2"};
    public String solution(int n) {
    
        // 14 / 3 = 4 -- 2
        // 4 / 3 = 1 --- 1
        // 1 --- 1
        
        // 1 1 2
        
        
        // 
        // 15 / 3 = 5 -- 0
        // 5 / 3 = 1 --- 2
        // 1 -- 1
        
        /// -> 1 1 4
        
        StringBuilder sb = new StringBuilder();
        
        while(n >= 1){
            
            int mod = n % 3;
        
            if(mod == 0){
                n -= 1;
            }
            n /= 3;
            
            sb.append(arr[mod]);
        }
        
        return sb.reverse().toString();
    }
}