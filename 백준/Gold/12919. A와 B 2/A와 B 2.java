import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String T;
    static String S;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        T = br.readLine();

        flag = false;

        go(new StringBuilder(T));
        if(flag) {
            sb.append(1).append("\n");
        }else sb.append(0).append("\n");

        System.out.println(sb);
    }

    static void go(StringBuilder now) {
        if(flag) return;


        if(now.length() == S.length()) {
            if(now.toString().equals(S)) {
                flag = true;
            }
            return;
        }

        if(now.charAt(0) == 'B'){
            StringBuilder next = new StringBuilder(now);
            next.deleteCharAt(0);
            next.reverse();
            go(next);
        }

        if(now.charAt(now.length() - 1) == 'A'){
            StringBuilder next = new StringBuilder(now);
            next.deleteCharAt(next.length() - 1);
            go(next);
        }


    }
}