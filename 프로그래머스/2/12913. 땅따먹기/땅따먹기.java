class Solution {
    static int n;
    static int m;
    
    int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = 4;
        
        int[][] dp = new int[n][m];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        int[][] arr = land;
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(Math.max(arr[i][0] + dp[i - 1][1], arr[i][0] + dp[i - 1][2] ), arr[i][0] + dp[i - 1][3]);
            
            dp[i][1] = Math.max(Math.max(arr[i][1] + dp[i - 1][0], arr[i][1] + dp[i - 1][2] ), arr[i][1] + dp[i - 1][3]);
            
            dp[i][2] = Math.max(Math.max(arr[i][2] + dp[i - 1][1], arr[i][2] + dp[i - 1][0] ), arr[i][2] + dp[i - 1][3]);
            
            dp[i][3] = Math.max(Math.max(arr[i][3] + dp[i - 1][1], arr[i][3] + dp[i - 1][2] ), arr[i][3] + dp[i - 1][0]);
            
        }
        
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[n - 1][i]);
        }
        return answer;
    }
}