import java.util.*;
class Solution {
    static int[] arr;
    static int n;
    static int m;
    static int maxCount;
    static int maxTotal;
    static int[][] users;
    static int[] emoticons;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        n = emoticons.length;
        m = users.length;
        arr = new int[n];
        this.emoticons = emoticons;
        this.users = users;
        dfs(0);
        answer[0] = maxCount;
        answer[1] = maxTotal;
        return answer;
    }
    
    static void dfs(int depth){
        if(depth == n){ // 이모티콘 탐색 끝
            // System.out.println(Arrays.toString(arr));
            
            int count = 0;
            int total = 0;
            
            for(int i=0; i < m; i++){
                int userPercent = users[i][0];
                int userPrice = users[i][1];
                int sum = 0;
                
                for(int j=0; j<n; j++){
                    if(arr[j] >= userPercent){ // 정한 기준 보다 이상이면
                        sum += (emoticons[j] * (100 - arr[j]))/100;
                    }
                }
                
                if(sum >= userPrice){
                    count ++;
                    sum = 0;
                }else total += sum;
                
                // System.out.println((i+1) + " " + sum + " " + count);
            }
            
            // System.out.println(count + " " + total);
            
            if(count > maxCount){
                maxCount = count;
                maxTotal = total;
                
            }else if(count == maxCount){
                maxTotal = Math.max(total, maxTotal);
            }
            return;
        }
        
        for(int i = 0; i < 4; i++){
            arr[depth] = (i + 1) * 10;
            dfs(depth + 1);
        }
    }
}