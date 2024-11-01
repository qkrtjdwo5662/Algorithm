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
        int[] arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
        }

        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < n-1; i++) {
            sum -= arr[i];
            answer += sum * arr[i];
        }

        // 12 * 2 24
        // 9 * 3 27
        // 4 * 5 20

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}