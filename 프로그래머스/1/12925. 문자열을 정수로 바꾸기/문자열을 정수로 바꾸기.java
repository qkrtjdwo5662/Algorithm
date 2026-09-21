class Solution {
    public int solution(String s) {
        int answer = 0;
        
        boolean plus = true;
        
        if(s.charAt(0) == '-'){
            plus = false;
        }
        
        StringBuilder sb = new StringBuilder();
        if(!plus){
            for(int i=1; i<s.length(); i++){
                sb.append(s.charAt(i));
            }
            answer = 0 - Integer.parseInt(sb.toString());
        }else{
            for(int i=0; i<s.length(); i++){
                sb.append(s.charAt(i));
            }
            answer = Integer.parseInt(sb.toString());
        }
        
        
        
        
        return answer;
    }
}