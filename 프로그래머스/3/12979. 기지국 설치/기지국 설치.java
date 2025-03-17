import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int index = 0;
        int pos = 1;
        
        while(pos <= n){
            // 기지국 범위 안에서만 움직임
           if(index < stations.length && pos >= stations[index] - w){
               pos = stations[index] + w + 1; // 기지국 최대 값 밖으로
               index++;
           }else{
               answer += 1; // 기지국 설치
               pos = pos + 2*w + 1; // 해당 범위를 가장 최소 구간으로 잡고 max 구간 + 1에 위치시킴
           } 
        }
        
        return answer;
    }
}