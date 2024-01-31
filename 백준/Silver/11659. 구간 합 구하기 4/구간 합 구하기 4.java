import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); // 수의 개수 N
        int m = Integer.parseInt(st.nextToken()); // 답을 구해야하는 횟수

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 누적합을 통해 start ~ end 구간의 원소 합을 구해야 함
            int sum = 0;
            sum = arr[end] - arr[start-1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
//        for (int i = 1; i <= n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//
//            int sum = 0;
//            for (int j = start; j <=end ; j++) {
//                sum = sum + arr[j];
//            }
//
//            sb.append(sum).append("\n");
//        }
//
//        System.out.print(sb);
    }
}
