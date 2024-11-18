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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int all = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int answer = 0;
        int left = 1;
        int right = arr[n - 1];

        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] >= mid) sum += mid;
                else sum += arr[i];
            }

            if(sum <= all) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else right = mid - 1;
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}