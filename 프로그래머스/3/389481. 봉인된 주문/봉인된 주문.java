import java.util.*;

class Solution {
    static List<String> candidate = new ArrayList<>(); // 후보 문자열 개수
    static long[] count;
    public String solution(long n, String[] bans) {
        count = new long[12];
        count[0] = 1;
        
        
        // 자리수마다 나올 수 있는 문자열 경우의 수 
        for(int i=1; i<12; i++){
            count[i] = count[i - 1] * 26;
        }
        
        for(int i=0; i<=bans.length; i++){
            String s = numToString(n + i);
            candidate.add(s);
        }
        
        Arrays.sort(bans, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else return Integer.compare(o1.length(), o2.length());
        });
        
        int count = 0;
        for(int i=0; i<bans.length; i++){
            if(candidate.get(count).length() > bans[i].length()) count ++;
            else if(candidate.get(count).length() == bans[i].length() && candidate.get(count).compareTo(bans[i]) >= 0) count ++;
        }
        System.out.println(numToString(1));
        return candidate.get(count);
        
    }
    
    static String numToString(long num){
        StringBuilder sb = new StringBuilder();
        int len = 1;
        // 계산 필요없는 것 제거
        for(int i=1; i<12; i++){
            if(num - count[i] > 0) {
                num -= count[i];
                len ++;
            }
            else break;
        }
        
        if(num > 0) num --; // a부터 시작
        
        char[] arr = new char[len];
        Arrays.fill(arr, 'a');
        
        for (int i = len - 1; i >= 0; i--) {
            arr[i] = (char) ('a' + num % 26);
            num /= 26;
        }
        
        for(int i = 0; i<len; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}