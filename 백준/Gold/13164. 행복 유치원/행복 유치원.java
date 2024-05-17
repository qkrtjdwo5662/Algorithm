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

        int n = Integer.parseInt(st.nextToken()); // 유치원 생 수
        int k = Integer.parseInt(st.nextToken()); // 조의 개수
        int[] arr = new int[n];
        int answer = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] diff = new int[n - 1];

        for (int i = 0; i <n-1 ; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        for (int i = 0; i < n- k; i++) {
            answer += diff[i];
        }


//         5 3
//         1 3 5 9 10
        //  2 2 1 4


        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}