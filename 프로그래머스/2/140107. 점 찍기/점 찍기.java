class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i<= d; i+= k){
            // y^2 = d^2 - x^2
            long y = (long)Math.sqrt((long)d*d - (long)i*i);
            answer += y/k + 1;
        }
        
        return answer;
    }
}