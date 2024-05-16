import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
           return Integer.compare(o1[0], o2[0]); 
        }); // 시작점 기준 정렬
        
        int answer = 1;
        
        int start = routes[0][0];
        int end = routes[0][1];
        
        for(int i=1; i<routes.length; i++){
            if(start <= routes[i][0] && routes[i][0] <= end){
                start = routes[i][0];
                end = Math.min(routes[i][1], end);
            }else{
                answer++;
                start = routes[i][0];
                end = routes[i][1];
            }
        }
        
        return answer;
    }
}