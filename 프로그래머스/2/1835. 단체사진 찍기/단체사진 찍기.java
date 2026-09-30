import java.util.*;
class Solution {
    static int n;
    static String[] data;
    static HashMap<Character, Integer> map;
    static boolean[] visited;
    static char[] members;
    static int[] result;
    static int answer;
    //static boolean flag;
    public int solution(int n, String[] data) {
        // 네오 프로도는 붙어서(나란히)
        // 튜브와 라이언은 적어도 세칸이상 떨어지기
        
        // data의 원소는 다음과 같음
        // 이게 N이 2일때
        // N~F=0 , R~T > 2 -> N과 F는 붙고, R과 T는 2칸 보다 떨어져서
        
        // 8!로 완탐 돌리고 조건에 맞는것만 체킹
        // 체킹할때도 최대 8 X 100 => 800 이라고 추정 
        // 8! X 800 해도 1억 미만 
        //flag = false;
        this.n = n;
        this.data = data;
        
        map = new HashMap<>();
        
        members = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        result = new int[members.length];
        int index = 0;
        for(int i=0; i<members.length; i++){
            map.put(members[i], index ++);
        }
        
        visited = new boolean[members.length];
        
        answer = 0;
        for(int i=0; i<members.length; i++){
            if(!visited[i]){
                visited[i] = true;
                result[0] = i;
                dfs(1, result);
                visited[i] = false;
            }
        }
        
        
        return answer;
    }
    
    static void dfs(int index, int[] arr){
        //if(flag) return;
        
        if(index == members.length) {
            // flag = true;
            if(distCheck(arr)) {
                answer ++;
            }
            return;
        }
        
        for(int i=0; i < members.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[index] = i;
                dfs(index + 1, arr);
                visited[i] = false;
            }
        }
        
    }
    
    static boolean distCheck(int[] arr){
        
        for(int i=0; i<data.length; i++){
            String s = data[i];
            
            char c1 = s.charAt(0);
            char c2 = s.charAt(2);
            
            char c3 = s.charAt(3);
            char c4 = s.charAt(4);
            
            int num1 = map.get(c1);
            int num2 = map.get(c2);
            
            int pos1 = -1;
            int pos2 = -1;
            
            
            for(int j=0; j<arr.length; j++){
                if(num1 == arr[j]){
                    pos1 = j;
                }
                
                if(num2 == arr[j]){
                    pos2 = j;
                }
            }

            int diff = Math.abs(pos1 - pos2) - 1; // 간격이니 1줄임
            //System.out.println(Arrays.toString(arr));
            //System.out.println(c1 + " " +c2 + " "+ c3 + " " + c4);
            //System.out.println(num1 + " " +num2);
            //System.out.println(pos1 + " " + pos2 + " "+ diff);            
            if(c3 == '='){
                if(diff != c4 - '0'){
                    return false;
                }
            }
            else if(c3 == '>'){
                if(diff <= c4 - '0'){
                    return false;
                }
            }
            else{
                if(diff >= c4 - '0'){
                    return false;
                }
            }
        }
        
        return true;
    }
}