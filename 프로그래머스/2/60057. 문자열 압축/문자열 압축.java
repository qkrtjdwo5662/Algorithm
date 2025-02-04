class Solution {
    public int solution(String s) {
        int answer = 1000;
        
        int n = s.length();
        int index = 1;
        
        
        while(index <= n){
            
            StringBuilder sb = new StringBuilder();
            
            String subString = "";
            String temp = "";
            int count = 1;
            
            for(int i = 0; i < n; i += index){
                
                if(i + index < n){
                    subString = s.substring(i, i + index);
                }else subString = s.substring(i, n);
                
                if(i == 0) temp = subString;
                else if(temp.equals(subString)) count ++;
                else{ // 다름
                    if(count > 1){
                        sb.append(count);
                        sb.append(temp);
                        temp = subString; // 새로운 값 갱신
                    }else{
                        sb.append(temp);
                        temp = subString;
                    }
                    
                    count = 1;
                    
                    
                }
                
                if(i + index >= n){
                    if(count > 1) sb.append(count);
                    sb.append(subString);
                }
                // System.out.println(subString);
                
            }
            answer = Math.min(answer, sb.length());
            // System.out.println(sb);
            index ++;
        }
        
        return answer;
    }
}