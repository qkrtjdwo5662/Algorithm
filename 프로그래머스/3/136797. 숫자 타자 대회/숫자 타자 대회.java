import java.util.*;

class Solution {
    static int[][][] dp; // left, right일때 거리 값
    static int[][] dist; // start -> target 일때의 최소 비용
    
    static final int n = 4;
    static final int m = 3;
    static int len;
    
    static char[][] board = new char[n][m];
    
    static Map<Character, int[]> map = new HashMap<>();
    
    static String numbers;
    static int[] ry = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] rx = {0, 1, 0, -1, 1, -1, 1, -1};
    
    static final int INF = 987654321;
    public int solution(String numbers) {
        int answer = 0;
        len = numbers.length();
        this.numbers = numbers;
        init();
        
        answer = go(0, 4, 6);
        
        return answer;
    }
    static int go(int depth, int left, int right){
        if(depth == len){
            return 0;
        }
        
        if(dp[left][right][depth]!= INF) return dp[left][right][depth];
        
        
        // left와 right
        int num = numbers.charAt(depth) - '0';
        int answer = INF;
        
        if(right != num){
            answer = Math.min(answer, go(depth + 1, num, right) + dist[left][num]);
        }
        
        if(left != num){
            answer = Math.min(answer, go(depth + 1, left, num) + dist[right][num]);  
        }
        
        dp[left][right][depth] = answer;
        return answer;
        
    }
    
    static int bfs(int y, int x, char target){
        if(board[y][x] == target) return 1;
        
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        visited[y][x] = true;
        
        deque.addLast(new int[]{y, x, 0});
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            
            int nowY = now[0];
            int nowX = now[1];
            int nowD = now[2];
            
            if(board[nowY][nowX] == target) return nowD;
            
            // 상하좌우 먼저
            for(int i=0; i<4; i++){
                int r = nowY + ry[i];
                int c = nowX + rx[i];
                
                if(r < 0 || c < 0 || r >= n || c >= m) continue;
                
                if(visited[r][c]) continue;
                
                visited[r][c] = true;
                deque.addLast(new int[]{r, c, nowD + 2});
            }
            
            // 대각 이동
            for(int i=4; i<8; i++){
                int r = nowY + ry[i];
                int c = nowX + rx[i];
                
                if(r < 0 || c < 0 || r >= n || c >= m) continue;
                
                if(visited[r][c]) continue;
                
                visited[r][c] = true;
                deque.addLast(new int[]{r, c, nowD + 3});
            }
        }
        
        return -1;
        
    }
    
    static void init(){
        // board 초기화
        board[0][0] = '1';
        board[0][1] = '2';
        board[0][2] = '3';
        
        board[1][0] = '4';
        board[1][1] = '5';
        board[1][2] = '6';
        
        board[2][0] = '7';
        board[2][1] = '8';
        board[2][2] = '9';
        
        board[3][0] = '*';
        board[3][1] = '0';
        board[3][2] = '#';
        
        // map 초기화
        map.put('1', new int[]{0, 0});
        map.put('2', new int[]{0, 1});
        map.put('3', new int[]{0, 2});
        
        map.put('4', new int[]{1, 0});
        map.put('5', new int[]{1, 1});
        map.put('6', new int[]{1, 2});
        
        map.put('7', new int[]{2, 0});
        map.put('8', new int[]{2, 1});
        map.put('9', new int[]{2, 2});
        
        map.put('*', new int[]{3, 0});
        map.put('0', new int[]{3, 1});
        map.put('#', new int[]{3, 2});
        
        dist = new int[10][10];
        
        for(char i = '0'; i<= '9'; i++){
            for(char j ='0'; j<='9'; j++){
                // i -> j
                int[] pos = map.get(i);
                
                dist[i - '0'][j - '0'] = bfs(pos[0], pos[1], j);
            }
        }
        
        dp = new int[10][10][len];
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<len; k++){
                    dp[i][j][k] = INF;
                }
            }
        }
        
    }
}