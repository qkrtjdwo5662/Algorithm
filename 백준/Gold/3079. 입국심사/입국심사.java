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
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        long left = 1;
        long right = Long.MAX_VALUE - 1;

        long answer = Long.MAX_VALUE;

        while(left <= right){
            long mid = (left + right)/ 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += mid/arr[i];
                
                if(sum > m) break;
            }

            if(sum >= m){
                answer =  Math.min(answer, mid);
                right = mid - 1;
            }else left = mid  + 1;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}