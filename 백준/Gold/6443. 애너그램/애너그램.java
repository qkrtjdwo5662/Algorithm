import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s;
    static int[] used;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            s = st.nextToken();
            used = new int['z' - 'a' + 1];

            for (int j = 0; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                used[index] ++;
            }

            backtrack(new StringBuilder());
        }

        System.out.println(sb);
    }

    static void backtrack(StringBuilder sbb){
        if(sbb.length() == s.length()){
            sb.append(sbb.toString()).append("\n");
            return;
        }

        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            if(used[i] > 0){
                sbb.append((char)('a' + i));
                used[i] -- ;
                backtrack(sbb);
                used[i] ++;
                sbb.deleteCharAt(sbb.length() - 1);
            }
        }
    }
}