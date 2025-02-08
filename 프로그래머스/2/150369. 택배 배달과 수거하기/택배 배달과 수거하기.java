class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int sumd = 0;
        int sump = 0;
        
        for(int i = n-1; i >= 0; i--){
            // cap만큼 실을 수 있음
            // 수거하던 배달하던 ㄱㄱ
            int count = 0;
            
            sumd += deliveries[i];
            sump += pickups[i];
            
            // 배달이나 수거할게 있나?
            while(sumd > 0 || sump > 0){
                // 있으면 여기 인덱스까진 한번은 오고 간거임
                // 몇번 와야하는지?
                
                sumd -= cap;
                sump -= cap;
                // 일단 빼
                
                count ++;
                
            }
            
            answer += (i + 1)*(count) * 2;
        }
        
        return answer;
    }
}