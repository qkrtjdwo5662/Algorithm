import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        long[] sumArr = new long[100 * 60 * 60 + 1];
        
        for(int i=0; i<logs.length; i++){
            String log = logs[i];
            String[] timeArr = log.split("-");
            String startTime = timeArr[0];
            String endTime = timeArr[1];
            
            sumArr[StringToInt(startTime)] ++;
            sumArr[StringToInt(endTime)] --;
        }
        
        for(int i=1; i<sumArr.length; i++){
            sumArr[i] += sumArr[i - 1]; // 구간합 갱신 
        }
        
        for(int i=1; i<sumArr.length; i++){
            sumArr[i] += sumArr[i - 1]; // 누적합 만들기
        }
    
        
        int playTime = StringToInt(play_time); // 전체 동영상 시간
        int advTime = StringToInt(adv_time); // 광고 시간
        
        int s = 1;
        int e = advTime + 1;
        long max = sumArr[advTime - 1];
        int temp = 0;
        
        while(e <= playTime){
            long sum = sumArr[e - 1] - sumArr[s - 1];
            
            if(sum > max){
                max = sum;
                temp = s;
            }
            
            s ++;
            e ++;
        }
        
        answer = IntToString(temp);
        return answer;
    }
    
    static int StringToInt(String time){
        String[] arr = time.split(":");
        
        int h = Integer.parseInt(arr[0]) * 60 * 60;
        int m = Integer.parseInt(arr[1]) * 60;
        int s = Integer.parseInt(arr[2]);
        
        return h + m + s;
    }
    
    static String IntToString(int time){
        int h = time/3600;
        
        time = time - 3600*h;
        
        int m = time/60;
        
        time = time - 60*m;
        
        int s = time;
        
        StringBuilder sb = new StringBuilder();
        
        if(h < 10) sb.append("0").append(h).append(":");
        else sb.append(h).append(":");
        
        if(m < 10) sb.append("0").append(m).append(":");
        else sb.append(m).append(":");
        
        if(s < 10) sb.append("0").append(s);
        else sb.append(s);
        
        return sb.toString();
    }
    
}