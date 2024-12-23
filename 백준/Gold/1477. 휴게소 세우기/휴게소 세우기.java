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
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = l;
        int answer = 0;
        while(left <= right){
            // mid가 답이 될 수 있나?

            int mid = (left + right) / 2;
            int count = 0;
            int temp = 0;

            for (int i = 0; i < n; i++) {
                count += (arr[i] - temp - 1) / mid;
                temp = arr[i];
            }

            count += (l - temp - 1) / mid;

            if(count > m){
                left = mid + 1;

            }else{
                answer = mid;
                right = mid - 1;
            }

        }
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}