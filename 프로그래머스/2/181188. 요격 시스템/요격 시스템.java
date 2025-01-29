import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 각 구간마다 몇개가 속해있는지?
        
        // 그래서 각 구간별로 미사일을 발사함
        
        // 좌표의 범위는 최대 1억 O(N) -> O(Log N)
                
        // 정렬, arr[0]을 기준
        // 범위에 포함되는지? 안되면 새로 갱신
        // 각 범위가 해당되는 것의 개수
        
        Arrays.sort(targets, (o1, o2) -> {
           if(o1[0] == o2[0]){
               return Integer.compare(o1[1], o2[1]);
           }else{
               return Integer.compare(o1[0], o2[0]);
           }
        });
        int n = targets.length;
        
        int s = -1;
        int e = -1;
        
        for(int i=0; i<n; i++){
            
            
            if(s== -1 && e == -1){
                s = targets[i][0];
                e = targets[i][1];
                
                answer ++;
                continue;
            }    
            
            
            if(s <= targets[i][0] && targets[i][0] < e){
                s = Math.max(s, targets[i][0]);
                e = Math.min(e, targets[i][1]); 
                // 범위 축소
            }else{
                s = targets[i][0];
                e = targets[i][1];
                
                answer ++;
            }
            
            //System.out.println(s + " " + e + " " + answer);
        }
        
        
        return answer;
    }
}