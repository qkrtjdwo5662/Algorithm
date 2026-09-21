import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>();
        
        long num = x;
        
        int i = 0;
        while(i < n){
            list.add(num);
            num+=x;
            i++;
        }
        
        long[] answer = new long[list.size()];
        
        for(int j=0; j<answer.length; j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
}