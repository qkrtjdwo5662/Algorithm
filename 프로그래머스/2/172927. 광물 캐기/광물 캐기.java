import java.util.*;

class Solution {
    static int n;
    static HashMap<String, Integer> numMap = new HashMap<>();
    static HashMap<String, Integer> pointMap = new HashMap<>();
    
    static int[][] info;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        n = minerals.length;
        n = Math.min(picks[0] * 5 + picks[1] * 5 + picks[2] * 5, n);
        
        
        int[][] arr = new int[(n / 5) + 1][6];
        info = new int[4][4];
        
        for(int i=1; i<4; i++){
            for(int j=1; j<4; j++){
                if(i <= j) info[i][j] = 1;
                else if(i - j == 1) info[i][j] = 5;
                else if(i - j == 2) info[i][j] = 25;
            }    
        }
        
        numMap.put("diamond", 1);
        numMap.put("iron", 2);
        numMap.put("stone", 3);
        
        pointMap.put("diamond", 100);
        pointMap.put("iron", 10);
        pointMap.put("stone", 1);
        
        
        
        int sum = 0;
        for(int i=0; i<n; i++){
            String mineral = minerals[i];
            int num = numMap.get(mineral);
            int point = pointMap.get(mineral);
            sum += point;
            
            arr[(i/5)][(i%5)] = num;
            
            if((i + 1) % 5 == 0){
                arr[(i/5)][5] = sum;
                sum = 0;
            }else if(i == n - 1){
                arr[(i/5)][5] = sum;
            }
        
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            return o2[5] - o1[5];
        }); // 5개씩 묶어서 정렬
        
        int now = -1;
        
        for(int i=0; i< arr.length; i++){
            int total = 0;
            if(picks[0] > 0){
                picks[0] --;
                now = 1;
            }else if(picks[1] > 0){
                picks[1] --;
                now = 2;
            }else if(picks[2] > 0){
                picks[2] --;
                now = 3;
            }else if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
            
            
            for(int j=0; j<arr[0].length - 1; j++){
                int num = arr[i][j];
                
                if(num == 0) break;
                total += info[now][num];
            }
            answer += total;
        }
        
            
        return answer;
    }
}