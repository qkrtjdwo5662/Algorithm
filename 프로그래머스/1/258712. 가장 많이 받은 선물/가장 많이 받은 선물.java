import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int[][] info;
    static int[] result;
    static String[] gFriends;
    static String[] gGifts;
    
    static int[] jisu;
    static int n;
    static int m;
    
    static int answer;
    
    public int solution(String[] friends, String[] gifts) {
        // friends는 친구의 이름
        // gifts A B // A -> B
        map = new HashMap<>();
        
        n = friends.length;
        m = gifts.length;
        gFriends = friends;
        gGifts = gifts;
        
        init();
        
        info = new int[n][n];
        jisu = new int[n];
        go();
        
        result = new int[n];
        answer = 0;
        go2();
        getResult();
        
        // System.out.println(Arrays.toString(result));
        return answer;
    }
    static void getResult(){
        
        for(int i=0; i<n; i++){
            answer = Math.max(result[i], answer);    
        }
    }
    
    static void go2(){
        
        for(int i=0; i<n - 1; i++){
            
           for(int j=i + 1; j<n; j++){
               int g = info[i][j];
               int r = info[j][i];
               
               if(g == r){
                   // 지수가 더 큰 사람이 더 작은 사람에게 선물
                   if(jisu[i] > jisu[j]){
                       result[i] ++;
                   }else if(jisu[i] < jisu[j]){
                       result[j] ++;
                   }
               }else if(g > r){
                   result[i] ++;
               }else{
                   result[j]++;
               }
           }
        }
    }
    
    static void go(){
        for(int i=0; i<m; i++){
            String [] strArr = gGifts[i].split(" ");
            String fName = strArr[0];
            String sName = strArr[1];
            int fKey = map.get(fName);
            int sKey = map.get(sName);
            
            info[fKey][sKey] ++; 
        }
        
        // 준거 - 받은거
        for(int i=0; i< n; i++){
            int g = 0;
            int r = 0;
            
            for(int j= 0; j<n; j++){
                g += info[i][j];
                r += info[j][i];
            }
            
            jisu[i] = g - r;
            
        }
        
        
    }
    
    static void init(){
        int index = 0;
        
        for(int i=0; i<gFriends.length; i++){
            map.put(gFriends[i], index);
            index ++;
        }
    }
}