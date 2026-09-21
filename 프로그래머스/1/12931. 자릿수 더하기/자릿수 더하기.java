import java.util.*;

public class Solution {
    public int solution(int n) {
        int num = n;
        int mod = 0;
        int answer = 0;

        while(num > 0){
            mod = num %10;
            answer += mod;
            num /= 10;
        }
        

        return answer;
    }
}