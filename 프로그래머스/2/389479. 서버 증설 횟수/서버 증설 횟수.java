import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int now = 0; // 현재 서버의 개수
        ArrayDeque<int[]> deque = new ArrayDeque<>(); 
        // 해당 시간에 몇개의 서버가 꺼져야하는지
        
        for(int i=0; i < players.length; i++){
            int player = players[i];
            // 여기서 i는 시간과 같음
            
            // 삭제할 서버 파악
            if(!deque.isEmpty() && deque.peekFirst()[0] == i){
                int[] poll = deque.pollFirst();
                now -= poll[1];
                
                // System.out.println(poll[0] + " "+ poll[1] + " 삭제");
            }
            
            // 서버 증설 여부 파악
            if(player/m  > now){
                // System.out.println(player/m - now  + "증가");
                deque.addLast(new int[]{i + k, player/m - now});
                answer += (player/m - now);
                now += (player/m - now);
            }
            
            
        }
        return answer;
    }
}