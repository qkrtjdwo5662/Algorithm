class Solution {
    public int solution(String[] babbling) {
       int answer = 0;

        String[] words = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            String s = babbling[i];

            if(s.contains("ayaaya")  
               || s.contains("yeye") 
               || s.contains("woowoo") 
               || s.contains("mama")) continue;
            
            for (int j = 0; j < words.length; j++) {
                s = s.replace(words[j], " ");
            }
            
            s = s.replace(" ", "");
            if(s.equals("")) answer++;
        }


        return answer;
    }
}