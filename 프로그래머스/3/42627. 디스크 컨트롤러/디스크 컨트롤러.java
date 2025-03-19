import java.util.*;

class Solution {
    static class Job{
        int num; // 작업 번호
        int startTime; // 요청 시간
        int time; // 작업 수행 시간
        
        public Job(int num, int startTime, int time){
            this.num = num;
            this.startTime = startTime;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int n = jobs.length;
        // System.out.println(Arrays.deepToString(jobs));
        int index = 0; // job의 탐색 인덱스
        int nowTime = 0; // 현재 시간
        int flagTime = 0;
        int tempTime = 0;
        int count = 0;
        PriorityQueue<Job> heap = new PriorityQueue<>((o1, o2) -> {
           if(o1.time != o2.time){
               return Integer.compare(o1.time, o2.time);
           }else{
               if(o1.startTime != o2.startTime){
                   return Integer.compare(o1.startTime, o2.startTime);
               }else{
                   return Integer.compare(o1.num, o2.num);
               }
           }
        });
        boolean flag = false; // 현재 실행중인 것이 있는가?
        boolean[] visited = new boolean[n];
        while(count < n){
            
            for(int i=0; i<n; i++){
                if(visited[i]) continue;
                
                int[] nowJob = jobs[i]; 
                
                if(nowJob[0] == nowTime){
                    heap.add(new Job(i, nowJob[0], nowJob[1]));
                    visited[i] = true;
                } // 대기큐에 넣기
            }
            
            
            if(!flag){ // 현재 실행하는 것이 없다면?
                if(!heap.isEmpty()){
                    Job job = heap.poll();
                    tempTime = job.startTime;
                    flagTime = nowTime + job.time;
                    flag = true;
                }
                
                nowTime ++;
                
            }else{ // 실행하는 것이 있다면
                if(nowTime == flagTime){
                    answer += (flagTime - tempTime);
                    count ++;
                    if(!heap.isEmpty()){ // 비어있지 않으면 바로 실행
                        Job job = heap.poll();
                        tempTime = job.startTime;
                        flagTime = nowTime + job.time;
                    }else{ // 비어있으면 넘겨라
                        flag = false;
                    }
                    
                    nowTime ++;
                }else nowTime ++;
            }
        }
        
        return (int)answer/n;
    }
}