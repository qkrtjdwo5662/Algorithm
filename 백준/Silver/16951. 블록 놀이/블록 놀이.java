import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] top;
    static int answer;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 탑 수
        k = Integer.parseInt(st.nextToken()); // 좋아하는 수 k

        st = new StringTokenizer(br.readLine());

        top = new int[n];

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            top[i] = h;
        }

        answer = n;
        loop:
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                int height = top[i] + (j-i) * k;

                if(height < 1) continue loop;

                if(height != top[j]) count ++;

            }

            answer = Math.min(answer, count);
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}