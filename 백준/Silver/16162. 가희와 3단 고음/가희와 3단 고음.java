import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 음의 개수
        int a = Integer.parseInt(st.nextToken()); // 고음의 첫 항
        int d = Integer.parseInt(st.nextToken()); // 공차

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int answer = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            if(answer == 0 && arr[i] == a) {
                answer = 1;
                now = a;
            }

            if(now != 0 && arr[i] == now + d) {
                answer ++;
                now = now + d;
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}