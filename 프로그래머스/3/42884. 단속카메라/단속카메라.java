import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        
        // System.out.println(Arrays.deepToString(routes));
        int start = routes[0][0];
        int end = routes[0][1];
        
        for(int i=1; i<routes.length; i++){
            if(start <= routes[i][0] && routes[i][0] <= end){
                start = Math.max(start, routes[i][0]);
                end = Math.min(end, routes[i][1]);
            }else{
                start = routes[i][0];
                end = routes[i][1];
                answer ++;
            }
        }
        
        return answer;
    }
}