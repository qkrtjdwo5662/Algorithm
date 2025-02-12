import java.util.*;
class Solution {
    static char[] arr = {'+', '-', '*'};
    static List<Character> list = new ArrayList<>();
    static boolean[] visited = new boolean[3];
    static String s;
    static List<Long> numList = new ArrayList<>();
    static List<Character> operatorList = new ArrayList<>();
    static List<Long> copyNumList;
    static long answer;
    public long solution(String expression) {
        answer = 0;
        // 50
        // 49
        // 50
        // 50
        s = expression;
        
         // 연산자의 위치는 변하지 않음
        
        StringTokenizer st = new StringTokenizer(s, "+|-|*");
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            numList.add(Long.parseLong(s)); // 원본 숫자 리스트
        }
        
        
        init(); // 숫자 리스트
        // System.out.println(operatorList);
        // System.out.println(numList);
        
        backtrack(0);
        return answer;
    }
    
    static void backtrack(int depth){
        if(depth == 3){
            // System.out.println(list);
            init();
            answer = Math.max(answer, cal());
            
            return;
        }
        
        for(int i=0; i<3; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                backtrack(depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    static void init(){
        operatorList = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '+' || c == '-' || c == '*'){
                operatorList.add(c);
            }
        }
        copyNumList = new ArrayList<>();
        
        for(int i=0; i<numList.size(); i++){
            copyNumList.add(numList.get(i));
        }
    }
    
    static long cal(){
        for(int i=0; i<3; i++){
            char operator = list.get(i);
            
            for(int j=0; j<operatorList.size(); j++){
                
                if(operatorList.get(j) == operator){
                    
                    long num1 = copyNumList.get(j);
                    long num2 = copyNumList.get(j + 1);

                    long calNum = 0;
                    if(operator == '+'){
                        calNum = num1 + num2;
                    }else if(operator == '-'){
                        calNum = num1 - num2;
                    }else calNum = num1 * num2;

                    copyNumList.remove(j);
                    copyNumList.remove(j);
                    copyNumList.add(j, calNum);
                    operatorList.remove(j);
                    j --;
                }
                
            }
            
            
        }
        
        return Math.abs((long)copyNumList.get(0));
    }
}