import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] count = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            count[num] ++;
        }

        int answer =0;
        // XOR 연산은 달라야 커짐.
        // 0 3 -> 3
        // 1 2 -> 3
        

        int pair = Math.min(count[0], count[3]);
        count[0] -= pair;
        count[3] -= pair;
        answer += pair * 3;

        pair = Math.min(count[1], count[2]);
        count[1] -= pair;
        count[2] -= pair;
        answer += pair * 3;

        pair = Math.min(count[1], count[3]);
        count[1] -= pair;
        count[3] -= pair;
        answer += pair * 2;

        pair = Math.min(count[0], count[2]);
        count[0] -= pair;
        count[2] -= pair;
        answer += pair * 2;

        pair = Math.min(count[2], count[3]);
        count[2] -= pair;
        count[3] -= pair;
        answer += pair;

        pair = Math.min(count[0], count[1]);
        count[0] -= pair;
        count[1] -= pair;
        answer += pair;

        answer += count[3] % 2 * 3;
        answer += count[2] % 2 * 2;
        answer += count[1] % 2;

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}