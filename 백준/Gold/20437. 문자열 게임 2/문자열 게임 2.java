import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int min;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            min = s.length();
            max = 0;

            for (int i = 'a'; i <= 'z' ; i++) {
                go((char) i, s, num);
            }

            if(min <= max){
                sb.append(min + " " + max).append("\n");
            }else sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }

    static void go(char c, String s, int num){
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) pos.add(i);
        }

        if (pos.size() < num) return;

        for (int i = 0; i <= pos.size() - num; i++) {
            int len = pos.get(i + num - 1) - pos.get(i) + 1;
            min = Math.min(min, len);
            max = Math.max(max, len);
        }
    }

}
