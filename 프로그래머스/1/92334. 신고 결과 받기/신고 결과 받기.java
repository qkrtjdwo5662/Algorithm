import java.util.*;

class Solution {
    static Map<String, Integer> reportCount = new HashMap<>();
    static Map<String, String> reportList = new HashMap<>();
    static Set<String> log = new HashSet<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        for(int i=0; i<report.length; i++){
            if(!log.contains(report[i])){ // 신고한 전적이 없으면 신고 카운트
                log.add(report[i]);
                
                String[] reportSplit = report[i].split(" ");
                // a가 b를 신고했다.
                String a = reportSplit[0];
                String b = reportSplit[1];
                
                reportCount.put(b, reportCount.getOrDefault(b, 0) + 1);
                reportList.put(a, reportList.getOrDefault(a, "") + b + " ");
            }
        
            
        }
        
        for(int i=0; i<id_list.length; i++){
            int count = 0;
            String a = id_list[i];
            String reportSentence = reportList.getOrDefault(a, "");
            
            if(reportSentence.equals("")) continue;
            
            String[] reportIdList = reportSentence.split(" ");
            
            for(int j=0; j<reportIdList.length; j++){
                String b = reportIdList[j];
                if(reportCount.get(b) >= k) count ++;
                
            }
            answer[i] = count;
            
        }
        return answer;
    }
}