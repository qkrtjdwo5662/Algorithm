import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static HashSet<String> set;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            set = new HashSet<>();
            answer = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();
                set.add(s);
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String s = st.nextToken();
                if(set.contains(s)){
                    answer++;
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }
}