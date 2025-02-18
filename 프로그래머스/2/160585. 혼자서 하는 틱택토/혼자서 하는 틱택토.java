class Solution {
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    static final int n = 3;
    static String[] board;
    public int solution(String[] board) {
        
        // 진행하면 안되는데도 진행했는지? 즉, 정상적으로 게임을 진행했는가
        // O가 둘 차례인데, X가 두었거나, X의 차례인데 O가 두었거나
        // O가 둘 차례인데, 이미 X가 이겼음
        // X가 둘 차례인데, 이미 O가 이겼음
        
        int answer = 0;
        int oCount = 0;
        int xCount = 0;
        this.board = board;
        for(int i=0; i<n; i++){
            String s = board[i];
            for(int j=0; j<n; j++){
                if(s.charAt(j) == 'O') oCount ++;
                else if(s.charAt(j) == 'X') xCount ++;
            }
        }
        
        if(checkCount(oCount, xCount)){
            return 0;
        }
        
        if(checkGameOver(oCount + xCount)){
            return 0;
        }
        
        
        return 1;
    }
    
    static boolean checkCount(int a, int b){
        if(a == b || a == b + 1){
            return false;
        }
        
        return true;
    }
    
    static boolean checkGameOver(int allCount){
        if(allCount %2 == 0){ // X가 둔 차례
            // O가 이미 이겼을때
            if(checkRow('O')) return true;
            if(checkCol('O')) return true;
            if(checkCrossFirst('O')) return true;
            if(checkCrossSecond('O')) return true;
        }else{ // O가 둔 차례
            // X가 이미 이겼을때
            if(checkRow('X')) return true;
            if(checkCol('X')) return true;
            if(checkCrossFirst('X')) return true;
            if(checkCrossSecond('X')) return true;
        }
        
        return false;
        
    }
    static boolean checkCrossFirst(char info){
        int r = 0;
        int c = 0;
        char temp = board[r].charAt(c);
        
        if(temp != info) return false;
        int count = 1;
        
        while(true){
            r += ry[0];
            c += rx[1];
                
            if(r < 0 || c < 0 || r >= n || c>=n ) break;
                
            if(info == board[r].charAt(c)) count ++;
        }
        
        if(count == 3) return true;
        
        return false;
    }
    
    static boolean checkCrossSecond(char info){
        int r = n - 1;
        int c = 0;
        char temp = board[r].charAt(c);
        
        if(temp != info) return false;
        int count = 1;
        
        while(true){
            r += ry[2];
            c += rx[1];
                
            if(r < 0 || c < 0 || r >= n || c>=n ) break;
                
            if(info == board[r].charAt(c)) count ++;
        }
        
        if(count == 3) return true;
        
        return false;
    }
    
    static boolean checkRow(char info){
        for(int i=0; i<n; i++){
            int r = i;
            int c = 0;
            char temp = board[r].charAt(c);
            
            if(temp != info) continue; // info 아니면 넘겨
            int count = 1;
            while(true){
                r += ry[1];
                c += rx[1];
                
                if(r < 0 || c < 0 || r >= n || c>=n ) break;
                
                if(info == board[r].charAt(c)) count ++;
            }
            
            if(count == 3) return true;
        }
        
        return false;
    }
    
    static boolean checkCol(char info){
        for(int i=0; i<n; i++){
            int r = 0;
            int c = i;
            char temp = board[r].charAt(c);
            
            if(temp != info) continue; // .이면 넘겨
            int count = 1;
            while(true){
                r += ry[0];
                c += rx[0];
                
                if(r < 0 || c < 0 || r >= n || c>=n ) break;
                
                if(info == board[r].charAt(c)) count ++;
            }
            if(count == 3) return true;
        }
        
        return false;
    }
}