import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        s = br.readLine();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'X') count ++;
            else if(s.charAt(i) == '.'){
                if(count == 0){
                    sb.append('.');
                }else if(count % 2 == 0) {
                    while (count >= 4) {
                        sb.append("AAAA");
                        count -= 4;
                    }

                    while (count >= 2) {
                        sb.append("BB");
                        count -= 2;
                    }
                    sb.append('.');
                    count = 0;
                }else{
                    System.out.println(-1);
                    return;
                }
            }


            if(i == s.length() - 1 && count != 0){
                if(count % 2 == 0){
                    while (count >= 4) {
                        sb.append("AAAA");
                        count -= 4;
                    }

                    while (count >= 2) {
                        sb.append("BB");
                        count -= 2;
                    }
                }else {
                    System.out.println(-1);
                    return;
                }

            }
        }

        System.out.println(sb);
    }


}