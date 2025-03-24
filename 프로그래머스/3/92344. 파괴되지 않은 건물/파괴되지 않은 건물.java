import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] sum = new int[n + 1][m + 1];
        
        int size = skill.length;
        for(int i=0; i<size; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == 1) degree = degree * -1;
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] += degree * -1;
            sum[r2 + 1][c1] += degree * -1;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        // 가로 누적
        for(int i=0; i<=n ; i++){
            for(int j=1; j<=m; j++){
                sum[i][j] += sum[i][j - 1];
            }
        }
        
        // 세로 누적
        for(int i=1; i<=n ; i++){
            for(int j=0; j<=m; j++){
                sum[i][j] += sum[i - 1][j];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] += sum[i][j];
                
                if(board[i][j] > 0) answer++;
            }
        }
        
        // System.out.println(Arrays.deepToString(sum));
        
        return answer;
    }
}