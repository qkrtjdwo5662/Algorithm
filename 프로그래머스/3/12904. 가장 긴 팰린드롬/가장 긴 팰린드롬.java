class Solution
{
    public int solution(String s)
    {

        // 가운데 기준 문자가 1개 일때, 2개 일때
        
        // 1개 일때
        int maxOne = 1;
        int n = s.length();
        
        for(int i=0; i<n; i++){
            // i에 해당하는 것이 기준 문자열
            
            int count = 1;
            int index = 1;
            while(i - index >=0 && i + index < n){
                char c1 = s.charAt(i + index);
                char c2 = s.charAt(i - index);
                
                if(c1 == c2) count +=2;
                else break;
                
                index ++;
            }
            maxOne = Math.max(maxOne, count);
        }
        
        
        int maxTwo = 0;
        
        for(int i=0; i< n-1; i++){
            
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            
            if(c1 == c2){
                int count = 2;
                int index = 1;
                
                while(i - index >=0 && i + 1 + index < n){
                    char c3 = s.charAt(i - index);
                    char c4 = s.charAt(i + 1 + index);
                
                    if(c3 == c4) count +=2;
                    else break;
                    index ++;
                }
                
                maxTwo = Math.max(maxTwo, count);
            }
        }
        
        
        return Math.max(maxOne, maxTwo);
    }
}