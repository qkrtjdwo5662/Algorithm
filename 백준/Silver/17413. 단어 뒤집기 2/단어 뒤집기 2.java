import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        String s = br.readLine();

        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '<') {
                flag = true;
                while(!deque.isEmpty()){
                    sb.append(deque.pollLast());
                }

                deque.addLast(s.charAt(i));

            }else if(s.charAt(i) == '>'){
                deque.addLast(s.charAt(i));

                while(!deque.isEmpty()){
                    sb.append(deque.pollFirst());
                }
                flag = false;
            }else if(s.charAt(i) == ' '){
                if(flag) {
                    deque.addLast(s.charAt(i));
                    continue;
                }

                while(!deque.isEmpty()){
                    sb.append(deque.pollLast());
                }
                sb.append(' ');
            }else deque.addLast(s.charAt(i));
        }

        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }

        System.out.println(sb);

    }
}
