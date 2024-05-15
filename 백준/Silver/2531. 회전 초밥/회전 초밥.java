import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] chobob = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            chobob[i] = num;
        }

        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if(map.containsKey(chobob[i])){
                map.put(chobob[i], map.get(chobob[i]) + 1);
            }else{
                map.put(chobob[i], 1);
            }
        }
        // 0 ~ k개 까지

        answer = map.size();
        if(!map.containsKey(c)) answer ++;

        for (int i = k; i < n+k; i++) {
            if(map.get(chobob[i - k]) > 1){
                map.put(chobob[i - k], map.get(chobob[i - k]) - 1);
            }else{
                map.remove(chobob[i - k]);
            }

            if(map.containsKey(chobob[i%n])){
                map.put(chobob[i%n], map.get(chobob[i%n]) + 1);
            }else{
                map.put(chobob[i%n], 1);
            }

            if(!map.containsKey(c)){
                answer = Math.max(answer, map.size() + 1);
            }else{
                answer = Math.max(answer, map.size());
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}