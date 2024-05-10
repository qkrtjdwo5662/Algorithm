import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        
        // 튜플 : 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음
        s = s.replace("{", "");
        s = s.replace("},", " ");
        s = s.replace("}}", "");
        // System.out.println(s);
        
        String[] arr = s.split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for(String el:arr){
            String[] arr2 = el.split(",");
            
            for(String el2:arr2){
                int num = Integer.parseInt(el2);
                
                if(map.containsKey(num)){
                    map.put(num, map.get(num) + 1);
                }else map.put(num, 1);
            }
        }
        
        int[] answer = new int[map.size()];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }
        
        int index = 0;
        while(!pq.isEmpty()){
            answer[index] = pq.poll()[0];
            index ++;
        }
        
        return answer;
    }
}