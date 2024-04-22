class Solution {
    static final int MOD = 1234567;
    public long solution(int n) {
        long answer = 0;
        
        
        // 3  3
        // 4  5
        // 5  8
        // 6  13
        
        
        long[] dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        
        for(int i=5; i<= 2000; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        return dp[n];
    }
}