import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            int count = 0;
            
            int temp = 0;
            
            for(int i=0; i<rocks.length; i++){
                if(rocks[i] - temp < mid) {
                    count ++;
                    continue;
                }
                
                temp = rocks[i];
            }
            
            if(distance - temp < mid) count ++;
            
            if(count > n){
                right = mid - 1;
            }else{
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
            
            
        }
        
        return answer;
    }
}