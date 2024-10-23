import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        // 211020101011
        // 211 0 2 01010 11
        
        String[] arr = s.split("0");
        
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i].replaceAll(" ", "");
            if(arr[i].length() == 0) continue;
            
            long num = Long.parseLong(arr[i]);
            
            if(check(num)) answer ++;
        }
        
        return answer;
    }
    
    static boolean check(long num){
        if(num < 2) return false;
        
        for(int i=2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}