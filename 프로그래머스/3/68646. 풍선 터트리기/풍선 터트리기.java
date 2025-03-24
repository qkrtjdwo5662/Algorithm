import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        int tempL = a[0];
        int tempR = a[n - 1];
        for(int i=1; i<n - 1; i++){
            if(tempL > a[i]) tempL = a[i];
            left[i] = tempL;
        }
        
        for(int i=n-2; i>0; i--){
            if(tempR > a[i]) tempR = a[i];
            right[i] = tempR;
        }
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        
        int answer = 2;
        for(int i=1; i<n - 1; i++){
            if(a[i] > left[i] && a[i] > right[i]) continue;
            // System.out.println(a[i]);
            answer++;
        }
        return answer;
    }
}