import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int left = 0;
        int right = 0;
        int size = s.length();

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        int answer = 0;

        while(left <= right){
            if(map.size() <= n) {
                right++;
                if(right == size) break;
                if(map.containsKey(s.charAt(right))){
                    map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
                }else map.put(s.charAt(right), 1);

                if(map.size() <= n) answer = Math.max(answer, right - left + 1 );
                else answer = Math.max(answer, right - left );

            }else{
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left ++;
            }

        }

        sb.append(answer).append("\n");
        System.out.println(sb);


    }
}