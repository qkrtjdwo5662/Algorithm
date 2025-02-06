import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        // 슬라이딩 윈도우
        
        int left = 0;
        int right = 0;
        int sum = sequence[right];
        
        
        int n = sequence.length;
        List<int[]> list = new ArrayList<>();
        
        while(left <= right && right < n){
            
            if(sum > k){
                sum -= sequence[left];
                left ++;
            }else if(sum == k){
                list.add(new int[]{left, right});
                sum -= sequence[left];
                left ++;
                    
                right ++;
                if(right == n) break;
                sum += sequence[right];
                
            }else{
                right ++;
                if(right == n) break;
                
                sum += sequence[right];
            }
            
            
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(o1[1] - o1[0] == o2[1] - o2[0]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o1[1] - o1[0], o2[1] - o2[0]);
        });
        
        answer = list.get(0);
        return answer;
    }
    
    
}