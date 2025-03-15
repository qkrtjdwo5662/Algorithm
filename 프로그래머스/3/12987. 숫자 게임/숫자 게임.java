import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = A.length;
        for(int i=0; i< n; i++){
            int num = B[i];
            
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        
        // System.out.println(treeMap);
        for(int i=0; i<n; i++){
            int num = A[i];
            
            if(treeMap.higherKey(num) != null){ // 초과키가 있는지
                int higherKey = treeMap.higherKey(num);
                treeMap.put(higherKey, treeMap.get(higherKey) - 1);
                
                if(treeMap.get(higherKey) == 0) treeMap.remove(higherKey);
                answer ++;
            }else{ // 초과키가 없다면 작은 값 제거
                int minKey = treeMap.firstKey();
                treeMap.put(minKey, treeMap.get(minKey) - 1);
                
                if(treeMap.get(minKey) == 0) treeMap.remove(minKey);
            }
        }
        
        
        return answer;
    }
}