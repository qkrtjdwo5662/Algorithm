import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int n;
    static String[] want;
    static int[] number;
    public int solution(String[] want, int[] number, String[] discount) {
        //want : 내가 사고자 하는 제품
        //number : 내가 사고자 하는 제품의 개수
        //discount : 할인 하는 품목
        map = new HashMap<>();
        n = number.length;
        
        this.want = want;
        this.number = number;
        
        int answer =0;
        for(int i = 0; i <= discount.length - 10; i++){
            init();
            for(int j=i; j<i + 10; j++){
                if(map.containsKey(discount[j])){
                   map.put(discount[j], map.get(discount[j]) - 1); 
                }else break;
            }
            
            if(count()) {
                answer+= 1;
            }
        }
        
        return answer;
    }
    static void init(){
        for(int i=0; i<n; i++){
            map.put(want[i], number[i]);
        }
        
    }
    
    static boolean count(){
        for(String key : map.keySet()){
           if(map.get(key) != 0) return false;
        }
        
        return true;
    }
}