import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            ArrayDeque<Character> deque = new ArrayDeque<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if(deque.isEmpty()) deque.addLast(c);
                else if(deque.peekLast() == c){
                    deque.pollLast();
                }else deque.addLast(c);
            }

            if(deque.isEmpty()) answer ++;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }

}
