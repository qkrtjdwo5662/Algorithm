import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        boolean[] deleted = new boolean[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i=0; i<n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1; // 끝은 -1
        
        for(int i=0; i<cmd.length; i++){
            String command = cmd[i];
            
            if(command.charAt(0) == 'U'){
                int num = Integer.parseInt(command.split(" ")[1]);
                while(num-- > 0){
                    k = prev[k]; // 이전 값으로 이동
                }
            }else if(command.charAt(0) == 'D'){
                int num = Integer.parseInt(command.split(" ")[1]);
                while(num-- > 0){
                    k = next[k];
                }
            }else if(command.charAt(0) == 'C'){
                deque.addLast(k);
                deleted[k] = true;
                
                if(next[k] != -1) prev[next[k]] = prev[k];
                if(prev[k] != -1) next[prev[k]] = next[k];
                
                if(next[k] != -1) k = next[k];
                else k = prev[k];
                
            }else if(command.charAt(0) == 'Z'){
                int num = deque.pollLast();
                deleted[num] = false;
                
                if(prev[num] != -1) next[prev[num]] = num;
                if(next[num] != -1) prev[next[num]] = num;
            }

        }
        
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n; i++){
            if(!deleted[i]) answer.append('O');
            else answer.append('X');
        }
        return answer.toString();
    }
}