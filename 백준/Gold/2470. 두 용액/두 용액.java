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

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int start = left;
        int end = right;

        int min = Integer.MAX_VALUE;

        while(left < right){
            int sum = (arr[left] + arr[right]);

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                start = left;
                end = right;
            }

            if(sum <= 0){
                left ++;
            }else right --;

        }

        sb.append(arr[start]).append(" ").append(arr[end]).append("\n");
        System.out.println(sb);
    }
}