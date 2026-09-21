import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        map.put(7, 0);
        map.put(8, 0);
        map.put(9, 0);
        
        for(int i=0; i<numbers.length; i++){
            map.put(numbers[i], map.get(numbers[i]) + 1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key) == 0){
                answer += key;
            }
        }
        
        
        return answer;
    }
}