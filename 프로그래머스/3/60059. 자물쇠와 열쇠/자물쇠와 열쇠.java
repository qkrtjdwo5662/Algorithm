class Solution {
    static int[][] key;
    static int[][] lock;
    static int n;
    static int m;
    
    static class Range{
        int r;
        int c;
        String s;
        
        public Range(int r, int c, String s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        this.key = key;
        this.lock = lock;
        n = lock.length;
        m = key.length;
        // 0 1 0
        // 1 0 0
        // 1 0 0
        
        // 0 0 0
        // 0 0 1
        // 0 1 0 
        
        // 1 1 1
        // 1 1 0
        // 1 0 1
        
        // 좌물쇠에서 홈을 포함하는 최소 직사각형
        // 해당 직사각형 크기만큼 좌물쇠의 부분을 포함하여 이동 시킴
        // 20 * 20 * 20 * 20 => 160,000
        
        boolean answer = true;
        Range range = lockRange();
        answer = checkKey(range.r, range.c, range.s);
        
        return answer;
    }
    
    static boolean checkKey(int r, int c, String s){
        // 0도 
        for(int i=0; i<m - r; i++){
            for(int j=0; j<m - c; j++){
                String s1 = "";
                
                for(int k=i; k<=i+r; k++){
                    for(int l=j; l<=j+c; l++){
                        if(key[k][l] == 0) s1 += 1;
                        else s1 += 0;
                    }
                }
                // System.out.println(s1);
                if(s.equals(s1)) return true;
            }
        }
        
        // 90도 
        for(int j=0; j<m - r; j++){
            for(int i= m - 1; i >= c; i--){
                String s1 = "";
                
                for(int k=j; k<=j+r; k++){
                    for(int l=i; l >= i-c; l--){
                        if(key[l][k] == 0) s1 += 1;
                        else s1 += 0;
                    }
                }
                if(s.equals(s1)) return true;
            }
        }
        
        for(int i=m - 1; i>= r; i--){
            for(int j= m-1; j>= c; j--){
                String s1 = "";
                
                for(int k=i; k >= i-r; k--){
                    for(int l=j; l >= j-c; l--){
                        if(key[k][l] == 0) s1 += 1;
                        else s1 += 0;
                    }
                }
                // System.out.println(s1);
                if(s.equals(s1)) return true;
            }
        }
        
        // 270도 
        for(int j=m - 1; j>=r; j--){
            for(int i= 0; i < m - c; i++){
                String s1 = "";
                
                for(int k=j; k>=j-r; k--){
                    for(int l=i; l <= i+c; l++){
                        if(key[l][k] == 0) s1 += 1;
                        else s1 += 0;
                    }
                }
                System.out.println(s1);
                if(s.equals(s1)) return true;
            }
        }        
        
        return false;
    }
    
    static Range lockRange(){
        int r1 = n;
        int c1 = n;
        int r2 = -1;
        int c2 = -1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int num = lock[i][j];
                
                if(num == 0){
                    r1 = Math.min(r1, i);
                    c1 = Math.min(c1, j);
                    r2 = Math.max(r2, i);
                    c2 = Math.max(c2, j);
                }
            }
        }
        
        String s = "";
        
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                s += lock[i][j];
            }
        }
        
        return new Range(r2 - r1, c2 - c1, s);
        
    }
}