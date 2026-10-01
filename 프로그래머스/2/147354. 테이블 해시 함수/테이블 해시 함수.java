import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col - 1] != o2[col -1]) return Integer.compare(o1[col - 1], o2[col- 1]);
            else return Integer.compare(o2[0], o1[0]);
        });
        
        // System.out.println(Arrays.deepToString(data));
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=row_begin - 1; i<=row_end - 1; i++){
            int num = 0;
            
            int[] arr = data[i];
            
            for(int j=0; j<arr.length; j++){
                num += arr[j] % (i + 1);
            }
            
            //System.out.println(num);
            list.add(num);
        }
        answer = list.get(0);
        for(int i=1; i<list.size(); i++){
            answer = answer ^ list.get(i);
        }
        
        return answer;
    }
}