class Solution {
    public static int answer;
    static int n;
    public int solution(int n) {
        answer = 1;
        this.n = n;
        int mid = n/2;

        for (int i = 1; i <= mid ; i++) {
            dfs(i, i);
        }

        return answer;
    }
    
    public static void dfs(int now, int sum){
        if(sum == n){
            answer++;
            return;
        }

        if(now + 1 + sum <= n){
            dfs(now + 1, sum + now + 1);
        }

    }
}