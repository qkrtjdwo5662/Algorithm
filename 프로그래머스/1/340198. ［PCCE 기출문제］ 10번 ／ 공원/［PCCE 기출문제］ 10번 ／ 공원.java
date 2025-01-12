import java.util.*;

class Solution {
    static int[][] map;
    static int n;
    static int m;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        n = park.length;
        m = park[0].length;
        map = new int[n][m];
        for(int i=0; i<n; i++){
            
            for(int j=0; j<m; j++){
                String s = park[i][j];
                
                if(!s.equals("-1")){
                   map[i][j] = 1; 
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){ // 돗자리 펼칠 수 있는 후보군
                    max = Math.max(check(i, j), max);
                }
            }
        }
        
        for(int i=0; i<mats.length; i++){
            if(mats[i] <= max) answer = mats[i];
            else break;
        }
        
        if(answer > 0) return answer;
        else return -1;
    }
    
    static int check(int startY, int startX){
        int index = 0;
        
        loop:
        while(true){
            index ++;

            // System.out.println(startY + " " + startX + " " + index + " " + n + " "  + m );
            
            if(startY + index > n || startX + index > m) break;
            
            for(int i=startY; i<startY + index; i++){
                for(int j=startX; j<startX + index; j++){
                    if(map[i][j] != 0) break loop;
                }
            }
            
        }
        
        return index - 1;
    }
}