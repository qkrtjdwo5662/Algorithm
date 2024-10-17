import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : weights){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num : map.keySet()){
            int count = map.get(num);
            
            // 같은 무게를 가진 경우
            if(count > 1) answer += (long)count * (count - 1) / 2;

            // 비율 계산
            int b = num * 2;
            if(b <= 1000 && map.containsKey(b)){
                answer += (long)count * map.get(b);
            }

            if(num % 3 == 0) {
                int c = num * 4 / 3;
                if(c <= 1000 && map.containsKey(c)){
                    answer += (long)count * map.get(c);
                }
            }

            if(num % 2 == 0) {
                int d = num * 3 / 2;
                if(d <= 1000 && map.containsKey(d)){
                    answer += (long)count * map.get(d);
                }
            }
        }
        
        return answer;
    }
}