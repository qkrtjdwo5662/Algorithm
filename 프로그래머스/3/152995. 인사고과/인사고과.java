import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int wanhoScore1 = scores[0][0];
        int wanhoScore2 = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else return o2[0] - o1[0];
        });
        int answer = 0;
        
        int n = scores.length; 
        
        int max = scores[0][1];
        
        for(int i=1; i<n; i++){
            int score = scores[i][1];
            
            if(max > score){
                
                if(wanhoScore1 == scores[i][0] && wanhoScore2 == scores[i][1]) return -1;
                scores[i][0] = -1;
                scores[i][1] = -1;      
                
            }else{
                max = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (o1, o2) -> {
            return Integer.compare(o1[0] + o1[1], o2[0] + o2[1]);
        });
        
        int count = 0;
        
        for(int i = n - 1; i>=0; i--){
            int total = scores[i][0] + scores[i][1];
            
            if(total > wanhoScore1 + wanhoScore2) count ++;
            else if(total == wanhoScore1 + wanhoScore2) return count + 1;
        }
        
        
        return answer;
    }
}