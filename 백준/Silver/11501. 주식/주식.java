import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }

            int max = 0;
            long sum = 0;
            for (int i = n - 1; i >=0; i--) {
                if(arr[i] > max){
                    max = arr[i];
                }else{
                    sum += max - arr[i];
                }
            }
            sb.append(sum).append("\n");

        }
        System.out.println(sb);
    }
}
