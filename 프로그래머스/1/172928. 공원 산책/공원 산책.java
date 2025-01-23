import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[][] map;
    static HashMap<String, Integer> routeMap;
    static int[] ry = {-1, 0, 1, 0};
    static int[] rx = {0, 1, 0, -1};
    
    static int y;
    static int x;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        n = park.length;
        m = park[0].length();
        
        map = new int[n][m];
        routeMap = new HashMap<>();
        
        routeMap.put("N", 0);
        routeMap.put("E", 1);
        routeMap.put("S", 2);
        routeMap.put("W", 3);
        
        y = -1;
        x = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char c = park[i].charAt(j);
                
                if(c == 'S'){
                    y = i;
                    x = j;
                }else if(c == 'X') map[i][j] = 1;
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String route = routes[i];
            
            String[] arr = route.split(" ");
            
            go(routeMap.get(arr[0]), Integer.parseInt(arr[1]));
        }
        
        answer[0] = y;
        answer[1] = x;
        return answer;
    }
    
    static void go(int d, int count){
        int tempY = y;
        int tempX = x;
        
        int index = 0;
        
        boolean flag = true;
        while(index < count){
            tempY += ry[d];
            tempX += rx[d];
            
            if(tempY < 0 || tempY >= n || tempX < 0 || tempX >= m) {
                flag = false;
                break;
            }
            
            if(map[tempY][tempX] == 1){
                flag = false;
                break;
            }
            
            index ++;
        }
        
        if(flag){
            y = tempY;
            x = tempX;
        }
        
        
    }
}