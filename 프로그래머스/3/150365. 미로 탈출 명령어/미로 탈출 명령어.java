import java.util.*;

class Solution {
    static int[] ry = {1, 0, 0, -1};
    static int[] rx = {0, -1, 1, 0};
    
    static String[] arr = {"d", "l", "r", "u"};
    static class Info{
        int x;
        int y;
        StringBuilder root; 
        int dist;
        
        public Info(int x, int y, StringBuilder root, int dist){
            this.x = x;
            this.y = y;
            this.root = root;
            this.dist = dist;
        }
    }
    
    static int n;
    static int m;
    static int x;
    static int y;
    static int r;
    static int c;
    static int k;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.k = k;
        
        String answer = bfs();
        
        return answer;
    }
    
    static String bfs(){
        if(Math.abs(r - x) + Math.abs(c - y) > k) return "impossible";
        
        ArrayDeque<Info> deque = new ArrayDeque<>();
        
        deque.addLast(new Info(x, y, new StringBuilder(), 0));
        
        while(!deque.isEmpty()){
            Info now = deque.pollFirst();
            // System.out.println(now.x + " " + now.y + " " + now.root + " " + now.dist);
            if(now.x == r && now.y == c && now.dist == k) return now.root.toString();
            
            for(int i=0; i<4; i++){
                int nextX = ry[i] + now.x;
                int nextY = rx[i] + now.y;
                
                if(nextX <= 0 || nextY <=0 || nextX > n || nextY > m) continue;
                if(Math.abs(r - nextX) + Math.abs(c - nextY) + now.dist > k) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(now.root.toString()).append(arr[i]);
                
                deque.addLast(new Info(nextX, nextY, sb, now.dist + 1));
                break;
            }
        }
        
        return "impossible"; 
    }
}