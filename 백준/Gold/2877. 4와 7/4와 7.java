import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(st.nextToken());

        k = k + 1;

        String binary = Integer.toString(k, 2);

        for (int i = 1; i < binary.length(); i++) {
            if(binary.charAt(i) == '0') sb.append('4');
            else sb.append('7');
        }
        System.out.println(sb);
    }
}
