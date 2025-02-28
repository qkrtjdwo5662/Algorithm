class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        int max_y = y;
        int max_x = x;
        int min_y = y;
        int min_x = x;
        
        int size = queries.length;
        for(int i = size - 1; i >=0; i--){
            int[] query = queries[i];
            
            int d = query[0];
            int move = query[1];
            
            if(d == 0){
                if(min_y > 0) min_y += move;
                
                max_y += move;
                if(max_y >= m) max_y = m-1;
            }else if(d == 1){
                if(max_y < m - 1) max_y -= move;
                
                min_y -= move;
                if(min_y < 0) min_y = 0;
            }else if(d == 2){
                if(min_x > 0) min_x += move;
                
                max_x += move;
                if(max_x >= n) max_x = n-1;
            }else if(d == 3){
                if(max_x < n - 1) max_x -= move;
                
                min_x -= move;
                if(min_x < 0) min_x = 0;
            }
            
            // System.out.println(max_x + " " + max_y);
            // System.out.println(min_x + " " + min_y);
            
            if (min_x >= n || min_y >= m || max_x < 0 || max_y < 0) return 0;
        }
        
        
        long answer = (long)(Math.abs(max_x - min_x) + 1) * (Math.abs(max_y - min_y) + 1);
        return answer;
    }
}