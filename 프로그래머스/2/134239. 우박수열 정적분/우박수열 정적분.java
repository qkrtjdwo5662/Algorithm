import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        
        int temp = k;
        int n = 0;
        
        // 우박순열로 순열 전체 길이 구하기
        while(temp != 1){
            if(temp % 2 == 0){ // 짝수
                temp /= 2;
            }else { // 홀수
                temp *= 3;
                temp += 1;
            }
            n ++;
        }
        
        // 우박순열 데이터 넣어주기
        int[] arr = new int[n + 1];
        
        temp = k;
        int index =0;
        while(temp != 1){
            arr[index] = temp;
            if(temp % 2 == 0){ 
                temp /= 2;
            }else {
                temp *= 3;
                temp += 1;
            }
            index ++;
        }
        
        // 끝 값 직접넣기
        arr[index] = 1;
        
        
        //System.out.println(Arrays.toString(arr));
        
        double[] area = new double[n]; // 넓이
        double[] sumArea = new double[n + 1]; // 누적합
        
        for(int i=0; i<n; i++){
            area[i] = (double)(arr[i] + arr[i + 1]) / 2;
        }
        
        for(int i=1; i<=n; i++){
            sumArea[i] += sumArea[i - 1] + area[i - 1];
        }
        
        //System.out.println(Arrays.toString(area));
        //System.out.println(Arrays.toString(sumArea));
        
        double[] answer = new double[ranges.length];
        
        for(int i=0; i<ranges.length; i++){
            int x1 = ranges[i][0];
            int x2 = n + ranges[i][1];
            
            if(x2 < x1) {
                answer[i] = -1;
                continue;
            }
            answer[i] = sumArea[x2] - sumArea[x1];
        }
        
        
        
        
        return answer;
    }
}