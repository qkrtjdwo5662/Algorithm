import java.util.*;

class Solution {
    static int answer = 0;
    static int n;
    static boolean[] visited;
    static int[] arr;
    public int solution(int n) {
        this.n = n;
        visited = new boolean[n];
        arr = new int[n];
        dfs(0);
        return answer;
    }
    
    static void dfs(int depth){
        if(depth == n){
            answer ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean check = false;
            for (int j = 0; j < depth; j++) {
                if(arr[j] == i || Math.abs(j - depth) == Math.abs(arr[j] - i)){
                    check = true;
                    break;
                }
            }
            if(check) continue;
            arr[depth] = i;
            dfs(depth + 1);
        }   
    }
}