class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // 숙련도의 최솟값을 구해라. -> 양의 정수 
        
        int left = 1;
        int right = 100_000;
        answer = right;
        // 32번 X 30만
        while(left <= right){
            int mid = (left + right) / 2; // 숙련도라고 잡고
            long total = 0;
            for(int i=0; i<diffs.length; i++){
                int diff = diffs[i];
                int time_cur = times[i];
            
                if(diff <= mid){
                    total += time_cur;
                }else{
                    int time_prev = 0;
                    if(i > 0){
                        time_prev = times[i - 1];
                    }
                    
                    int count = diff - mid; // 틀린 횟수
                    total += count* (time_prev + time_cur) + time_cur;
                }
            }
            
            if(total > limit){
                
                left = mid + 1;
            }else{ // 줄일 가능성이 생긴다
                right = mid - 1;
                answer = mid;
            }
        }
        
        
        return answer;
    }
}