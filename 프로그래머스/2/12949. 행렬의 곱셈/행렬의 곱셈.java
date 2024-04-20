class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int n = answer.length;
        int m = answer[0].length;
        int l = arr1[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int sum = 0;
                for(int k=0; k<l; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                
                
                answer[i][j] = sum; 
            }
        }
        
        return answer;
    }
}