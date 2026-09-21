

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        String cString = s.toLowerCase();
        for(int i=0; i<cString.length(); i++){
            if(cString.charAt(i) == 'p'){
                pCount ++;
            }
            
            if(cString.charAt(i) == 'y'){
                yCount ++;
            }
        }
        
        if(pCount == yCount){
            answer = true;
        }else answer = false;

        return answer;
    }
}