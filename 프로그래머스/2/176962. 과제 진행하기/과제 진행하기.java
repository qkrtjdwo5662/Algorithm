import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length; // 전체 길이
        
        List<String> answerList = new ArrayList<>();
        String[] answer = new String[n];
        
        // 1. plans 정렬
        Arrays.sort(plans, (o1, o2) -> {
            int o1h = Integer.parseInt(o1[1].split(":")[0]);
            int o1m = Integer.parseInt(o1[1].split(":")[1]);
            
            int o2h = Integer.parseInt(o2[1].split(":")[0]);
            int o2m = Integer.parseInt(o2[1].split(":")[1]);
            
            if(o1h == o2h) return Integer.compare(o1m, o2m);
            else return Integer.compare(o1h, o2h);
        });
        
        ArrayDeque<String[]> deque = new ArrayDeque<>(); // 남은 과목, 시간 넣어주기
        
        for(int i=0; i < n - 1; i++){
            String[] now = plans[i];
            String[] next = plans[i + 1];
            
            String nowTime = calTime(now[1], now[2]);
            String nextTime = next[1];
            
            int nth = Integer.parseInt(nowTime.split(":")[0]);
            int ntm = Integer.parseInt(nowTime.split(":")[1]);
            
            int neth = Integer.parseInt(nextTime.split(":")[0]);
            int netm = Integer.parseInt(nextTime.split(":")[1]);
            
            if(neth < nth || (neth == nth && netm < ntm)){
                // 시간 차이 만큼 stack에 넣기
                String[] remain = new String[2];
                remain[0] = now[0];
                remain[1] = diffTime(nowTime, nextTime);
                
                // System.out.println(Arrays.toString(remain) + nowTime + " " + nextTime);
                deque.addLast(remain);
                
            }else{
                answerList.add(now[0]);
                
                // 중간에 스택에 담긴 거 꺼내서 쓸 수 있니?
                
                while(!deque.isEmpty()){
                    String[] peek = deque.peekLast();
                    
                    String cal = calTime(nowTime, peek[1]);
                    
                    int temph = Integer.parseInt(cal.split(":")[0]);
                    int tempm = Integer.parseInt(cal.split(":")[1]);
                    
                    if(neth < temph || (neth == temph && netm < tempm)){
                        String[] remain = new String[2];
                        remain[0] = peek[0];
                        remain[1] = diffTime(cal, nextTime);
                        
                        deque.pollLast();
                        deque.addLast(remain);
                        
                        break;
                    }
                    
                    answerList.add(peek[0]);
                    deque.pollLast();
                    nowTime = cal;
                }
            }
        }
        
        
        // 마지막
        String[] nowPlan = plans[n - 1];
        answerList.add(nowPlan[0]);
        
        while(!deque.isEmpty()){
            String[] now = deque.pollLast();
            answerList.add(now[0]);
        }
        
        for(int i=0; i<n; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    static String diffTime(String time1, String time2){
        String[] split1 = time1.split(":");
        String[] split2 = time2.split(":");
        
        int h1 = Integer.parseInt(split1[0]);
        int m1 = Integer.parseInt(split1[1]);
        
        int h2 = Integer.parseInt(split2[0]);
        int m2 = Integer.parseInt(split2[1]);
        
        int h_diff = h1 - h2;
        int m_diff = m1 - m2;
        
        if(m_diff < 0){
            m_diff += 60;
            h_diff -= 1;
        }
        
        while(h_diff >= 1){
            h_diff -= 1;
            m_diff += 60;
        }
        
        return String.valueOf(m_diff); // 차이 분으로 계산
    }
    
    static String calTime(String now, String playtime){
        String[] split = now.split(":");
        // System.out.println(now + " " + playtime);
        int nh = Integer.parseInt(split[0]); // 현재 시
        int nm = Integer.parseInt(split[1]); // 현재 분
        
        int pt = Integer.parseInt(playtime); // 플레이 시간
        
        if(pt >= 60){ // 더하는 시간 60분 이상 시 
            nh += 1; // 시간 증가
            
            pt -= 60;
            nm += pt;
        }else nm += pt;
        
        if(nm >= 60){ // 분 60분 초과 시 
            nh += 1;
            nm -= 60;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(nh).append(":").append(nm);
        
        return sb.toString();
    }
}