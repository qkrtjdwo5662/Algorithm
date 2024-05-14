class Solution {
    static int[] ry = {1, -1, 0, 0};
    static int[] rx = {0, 0, 1, -1};
    static final int MAX = 5;
    static final int MIN = -5;
    public int solution(String dirs) {
        int answer = 0;
        int[] start = new int[2];
        boolean[][][][] visited = new boolean[11][11][11][11]; // start -> end
        for(int i=0; i<dirs.length(); i++){
            char ch = dirs.charAt(i);
            int d = direction(ch);
            
            int r = start[0] + ry[d];
            int c = start[1] + rx[d];
            
            if(r < MIN || c<MIN || r>MAX || c>MAX) continue;
            
            if(!visited[start[0] + 5][start[1] + 5][r + 5][c + 5] && !visited[r + 5][c + 5][start[0] + 5][start[1] + 5]){
                visited[start[0] + 5][start[1] + 5][r + 5][c + 5] = true;
                visited[r + 5][c + 5][start[0] + 5][start[1] + 5] = true;
                answer ++;
            }
            
            start[0] = r;
            start[1] = c;
        }
        
        return answer;
    }
    
    static int direction(char c){
        if(c == 'U'){
            return 0;
        }else if(c == 'D'){
            return 1;
        }else if(c == 'R'){
            return 2;
        }else{
            return 3;
        }
    }
}