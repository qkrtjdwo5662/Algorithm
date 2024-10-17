import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = Math.max(maxNum(arrayA, arrayB), maxNum(arrayB, arrayA));
    
        return answer;
    }
    static int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        return gcd(b, a%b);
    }
    
    static int maxNum(int[] arrayA, int[] arrayB){
        int temp = 0;
        int result = arrayA[0];
        
        for(int i=1; i<arrayA.length; i++){
            int num = arrayA[i];
            result = gcd(result, num);
        }
        
        for(int i=0; i<arrayB.length; i++){
            if(arrayB[i] % result == 0) return 0;
        }
        
        return result;
    }
}