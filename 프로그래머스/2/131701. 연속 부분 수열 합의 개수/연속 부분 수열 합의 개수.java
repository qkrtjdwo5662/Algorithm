import java.util.*;
class Solution {
    static HashSet<Integer> set;
    public int solution(int[] elements) {
        // 0  0    1    2    3   4
        // 1  01   12   23   34  40
        // 2  012  123  234  340 401
        // 3  0123 1234
        // 4  01234
        set = new HashSet<>();
        int n = elements.length;
        
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                int sum = 0;
                for(int k=j; k<=j+i; k++){
                    sum += elements[k%n];
                    // System.out.print(k + " ");
                }
                // System.out.println(sum);
                set.add(sum);
            }
        }
        // System.out.println(set.size());
        return set.size();
    }
}