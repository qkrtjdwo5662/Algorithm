import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        // 2 1 1 2 3 1 2 3 1
        // 1 2 3 1
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<ingredient.length; i++){
            list.add(ingredient[i]);
            if(list.size() >= 4){
                String s = "";
                for(int j=list.size() - 1; j >= list.size() - 4; j--){
                    s += list.get(j);
                }
                
                if(s.equals("1321")) {
                    for(int j= 0; j < 4; j ++){
                        list.remove(list.size() - 1);
                    }
                    answer ++;
                }
                
            }
        }
        
        return answer;
    }
}