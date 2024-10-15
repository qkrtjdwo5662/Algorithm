class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = name.length() - 1;
        for(int i=0; i<n; i++){
            char c = name.charAt(i);
            
            int front = c - 'A';
            int back = 'Z' - c + 1;
            
            answer += Math.min(front, back);
            
            int index = i + 1;
            while(index < name.length() && name.charAt(index) == 'A'){
                index ++;
            }
            
            move = Math.min(move, i + name.length() - index + Math.min(i, name.length() - index));
        }
        
        return answer + move;
    }
}