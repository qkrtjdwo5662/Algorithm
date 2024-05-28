class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = 1_000_000_000;
        
        // 7 10 14 20 21 28  
        long left = 0;
        long right = max * n;
        
        while(left + 1 < right){
            long center = (left + right) / 2;
            long check = 0;
            
            for(int i=0; i < times.length; i++){
                check += center / times[i];
            }
            
            if(check >= n){
                right = center;
            }else{
                left = center;
            }
        }
        answer = right;
        return answer;
    }
}