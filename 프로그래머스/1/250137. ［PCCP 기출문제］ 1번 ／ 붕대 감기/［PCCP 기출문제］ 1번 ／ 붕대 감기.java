class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;// 현재 체력
        
        int attacksIndex = 0; // 공격 인덱스
        int time = 1; // 시간
        int count = 0; // 연속 성공
        
        
        while(attacksIndex < attacks.length && answer > 0){
            
            int[] now = attacks[attacksIndex];
            
            if(time == now[0]){
                answer -= now[1]; // 공격 시간 같으면 체력깜
                attacksIndex ++; // 인덱스 증가 시키고
                count = 0;
            }else{
                if(count < bandage[0]){
                    answer += bandage[1];
                    count ++;
                }
                
            }
            
            if(count == bandage[0]){ // 연속 성공 시전시간에 도달 했으면
                    answer += bandage[2]; 
                    count = 0;
            }
            
            if(answer > health) answer = health;
            
            time ++; // 0초면 시간 증가
        }
        
        if(answer <= 0) return -1; 
        return answer;
    }
}