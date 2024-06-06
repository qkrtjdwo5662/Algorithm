import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        StringBuilder compare = new StringBuilder("IOI");
        for (int i = 1; i < n ; i++) {
            compare.append("OI");
        }

        int answer = 0;

        // 10101 10
        for (int i = 0; i < s.length() - compare.length() + 1; i++) {
            StringBuilder compare2 = new StringBuilder();
            for (int j = 0; j < compare.length(); j++) {
                compare2.append(s.charAt(i+j));
            }
            if(compare2.toString().equals(compare.toString())) answer++;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}