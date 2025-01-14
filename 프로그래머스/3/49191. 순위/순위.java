class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i=0; i<results.length; i++){
            int u = results[i][0];
            int v = results[i][1];
            
            dp[u][v] = 1;
            dp[v][u] = -1;
        }
        
        
        for(int k=1; k<=n; k ++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dp[i][j] == 0){
                        if(dp[i][k] == 1 && dp[k][j] == 1){
                            dp[i][j] = 1;
                        }else if(dp[i][k] == -1 && dp[k][j] == -1){
                            dp[i][j] = -1;
                        }
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(dp[i][j] != 0) count ++;
            }
            
            if(count == n - 1) answer ++;
        }
        
        return answer;
    }
}