import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int n = sequence.length;
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        for(int i=0; i<n; i++){
            if(i % 2 == 0){
                arr1[i] = -1 * sequence[i];
                arr2[i] = sequence[i];
            }else{
                arr1[i] = sequence[i];
                arr2[i] = -1 * sequence[i];
            }
        }
        
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        
        dp1[0] = arr1[0];
        dp2[0] = arr2[0];
        
        long max1 = dp1[0];
        long max2 = dp2[0];
        
        for(int i=1; i<n; i++){
            dp1[i] = (long) Math.max(arr1[i], dp1[i - 1] + arr1[i]);
            dp2[i] = (long) Math.max(arr2[i], dp2[i - 1] + arr2[i]);
            
            max1 = Math.max(max1, dp1[i]);
            max2 = Math.max(max2, dp2[i]);
        }
        
        
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(dp1));
        answer = Math.max(max1, max2);
        return answer;
    }
}