import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int n = weights.length;
        
        Arrays.sort(weights);
        
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i=0; i<weights.length; i++){
            double num = weights[i];
            
            double a = num;
            
            double b = num / 2;
            
            double c = num * 3/4;
            
            double d = num * 2/3;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        return answer;
    }
}