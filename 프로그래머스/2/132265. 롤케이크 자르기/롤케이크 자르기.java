import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int left = 0;
        int right = topping.length - 1;
        
        int mid = (left + right) / 2;
            
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
            
        for(int i=0; i<=mid; i++){
            leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1);
        }
        for(int i=mid + 1; i<=right; i++){
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }
        
        if(leftMap.size() == rightMap.size()) answer ++;
        
        int index = mid;
        while(index < right){
            index ++;
            
            leftMap.put(topping[index], leftMap.getOrDefault(topping[index], 0) + 1);
            rightMap.put(topping[index], rightMap.get(topping[index]) - 1);
            
            if(rightMap.get(topping[index]) == 0) rightMap.remove(topping[index]);
                
            if(leftMap.size() == rightMap.size()) answer ++;
        }
        
        
        leftMap = new HashMap<>();
        rightMap = new HashMap<>();
            
        for(int i=0; i<=mid; i++){
            leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1);
        }
        for(int i=mid + 1; i<=right; i++){
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }
        
        index = mid;
        while(index > 0 ){
            
            
            rightMap.put(topping[index], rightMap.getOrDefault(topping[index], 0) + 1);
            leftMap.put(topping[index], leftMap.get(topping[index]) - 1);
                                     
            if(leftMap.get(topping[index]) == 0) leftMap.remove(topping[index]);
            
            if(leftMap.size() == rightMap.size()) answer ++;
            
            index --;
        }
        
        return answer;
    }
}