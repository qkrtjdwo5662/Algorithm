class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int n = diffs.length;
        // 난이도의 범위 
        int left = 1;
        int right = 100_000;
        
        while(left <= right){
            int mid = (left + right)/2; // 현재 난이도
            
            long total = times[0]; // 초기에는 무조건 난이도 1이니까 첫번째 퍼즐 푸는 시간 default로 잡아주면 됨
            
            for(int i=1; i<n; i++){
                int diff = diffs[i]; // 현재 퍼즐 난이도
                int time = times[i]; // 퍼즐 푸는데 걸리는 시간
                
                if(mid >= diff){
                    total += time;
                    
                }else{
                    int count = diff - mid; // 틀림 카운트
                    
                    total += (time + times[i - 1]) * count + time;
                }
                
                
            }
            
            if(total <= limit){ // 만족하니까 숙련도 더 낮춰
                answer = mid; // 답 최신화
                right = mid - 1;
            }else{
                left = mid + 1; // 숙련도 좀 더 올려야함
            }
        }
        
        return answer;
    }
}