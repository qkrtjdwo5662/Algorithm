import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(n > s) return new int[]{-1};
            
        int num = s/n;
        int mod = s%n;
        
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            answer[i] = num;
            
            if(i >= n - mod) answer[i] ++;
        }
        
        
        return answer;
    }
}