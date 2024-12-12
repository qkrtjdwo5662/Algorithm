import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder max;
    static StringBuilder min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        max = new StringBuilder();
        min = new StringBuilder();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'M' && i != s.length() - 1){
                count ++;

            }else if(s.charAt(i) == 'M' && i == s.length() - 1){
                count ++;
                addData(max, count, false, 1);
                addData(min, count, false, 0);
            }else{
                if(count != 0){
                    addData(max, count, true, 1);
                    addData(min, count, true, 0);

                    count = 0;
                }else{
                    max.append(5);
                    min.append(5);
                }

            }
        }

        System.out.println(max.toString());
        System.out.println(min.toString());
    }

    static void addData(StringBuilder sb, int count, boolean check, int status){
        if(check){ // K
            if(status == 1){
                sb.append(5);
                for (int i = 0; i < count ; i++) {
                    sb.append(0);
                }
            }else{
                sb.append(1);
                for (int i = 0; i < count - 1; i++) {
                    sb.append(0);
                }
                sb.append(5);
            }
        }else{ // M
            if(status == 1){
                for (int i = 0; i < count; i++) {
                    sb.append(1);
                }
            }else{
                sb.append(1);
                for (int i = 0; i < count - 1; i++) {
                    sb.append(0);
                }
            }

        }
    }
}