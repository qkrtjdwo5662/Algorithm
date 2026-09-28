import java.util.*;

class Solution {
    static int[] ry = {0, 1, 0, 1};
    static int[] rx = {1, 0, -1, 0};
    static int N;
    static int W;
    static int NUM;
    
    static int[][] map;
    static int result;
    
    static int posY;
    static int posX;
    public int solution(int n, int w, int num) {
        // n 상자의 개수 
        N = n;
        W = w;
        NUM = num;
        
        map = new int[(n + w - 1) / w][w];
        // num가 적힌 상자를 꺼내려면 위에 몇개 꺼내야함
        posY = 0;
        posX = 0;
        
        if (W == 1) {
            return N - NUM + 1; // 1열일 때는 위에 쌓인 상자 수가 바로 계산됨
        }
        
        go(0, 0, 1, 0, false);
        
        // System.out.println(Arrays.deepToString(map));
    
        count();
        return result;
    }
    static void count(){
        result = 0;
        while(true){
            if(posY >= map.length) return;
            
            if(map[posY][posX] == 0) return;
            
            result++;
            posY ++;
                
        }
    }
    
    static void go(int ny, int nx, int n, int d, boolean isUp){
        if(n == N + 1){
            return;
        }
        
        
        map[ny][nx] = n; // 넣어준다.
        
        if(n == NUM){
            posY = ny;
            posX = nx;
        }
        
        int y = ny + ry[d];
        int x = nx + rx[d];
        
        // 그대로 다음번에 들이박는다면?
        // 위로 가는건 제외..
        
        if(x < 0 || x >= W){
            y = ny + ry[(d + 1)%4];
            x = nx + rx[(d + 1)%4];
            go(y, x, n + 1, (d + 1 )% 4, true);
            return;
        }
        
        // 위로 올라온거면 방향 전환
        if(isUp){
            y = ny + ry[(d + 1)%4];
            x = nx + rx[(d + 1)%4];
            go(y, x, n + 1, (d + 1) % 4, false);
        }else go(y, x, n + 1, d, false);
        
    }
    
}