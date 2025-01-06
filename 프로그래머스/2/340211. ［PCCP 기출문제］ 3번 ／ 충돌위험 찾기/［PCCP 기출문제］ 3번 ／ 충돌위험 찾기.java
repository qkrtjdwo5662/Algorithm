import java.util.*;

class Solution {
    static int n; // 포인트 개수 
    static int x; // 로봇 수
    static int m; // 경로 개수
    
    static int answer;
    
    static int[] ry = {1, -1, 0, 0};
    static int[] rx = {0, 0, 1, -1};
    
    static Map<Integer, Map<String, Integer>> timestamp = new HashMap<>();

    
    public int solution(int[][] points, int[][] routes) {
        n = points.length;
        x = routes.length;
        m = routes[0].length;
        answer = 0;
        
        for(int i=0; i<x; i++){
            // 로봇 마다 
            int startNum = routes[i][0];
            
            if(!timestamp.containsKey(0)){
                timestamp.put(0, new HashMap<>());
                Map<String, Integer> map = timestamp.get(0);
                String s = points[startNum-1][0] + "," + points[startNum-1][1];
                map.put(s, 1);
                
            }else{
                Map<String, Integer> map = timestamp.get(0);
                String s = points[startNum-1][0] + "," + points[startNum-1][1];
                if(map.containsKey(s)){
                    map.put(s, map.get(s) + 1);
                }else{
                    map.put(s, 1);
                }
                
            }
            
            int time = 0;
            for(int j=1; j<m; j++){
                // 경로 ㄱㄱ
                int nodeNum = routes[i][j];
                time = go(points[startNum-1], points[nodeNum-1], time);
                startNum = nodeNum; // 시작점 최신화
            }
        }
        
        for(int time : timestamp.keySet()){
            Map<String, Integer> map = timestamp.get(time);
            
            for(String key : map.keySet()){
                if(map.get(key) > 1) answer ++;
            }
        }
        
        return answer;
    }
    
    static int go(int[] start, int[] end, int time){
        int nowY = start[0];
        int nowX = start[1];
        
        
        while(true){
            time ++;
            
            if(nowY < end[0]){
                nowY ++;
            }else if(nowY > end[0]){
                nowY --;
            }else if(nowX < end[1]){
                nowX ++;
            }else if(nowX > end[1]){
                nowX --;
            }
            
            if(!timestamp.containsKey(time)){
                timestamp.put(time, new HashMap<>());
                Map<String, Integer> map = timestamp.get(time);
                String s = nowY + "," + nowX;
                map.put(s, 1);
                
            }else{
                Map<String, Integer> map = timestamp.get(time);
                String s = nowY + "," + nowX;
                if(map.containsKey(s)){
                    map.put(s, map.get(s) + 1);
                }else{
                    map.put(s, 1);
                }
                
            }
            
            if(nowY == end[0] && nowX == end[1]) break;
        }
        
        return time;
    }
    

}