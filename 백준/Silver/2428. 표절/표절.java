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
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        long sum = 0;
        // size(Fj)*0.9 <= size(Fi) <= size(Fj)

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n-1;
            int index = i;
            while(left  <= right){
                int mid = (left + right) / 2;

                if(arr[i] * 10 >= arr[mid] * 9){
                    left = mid + 1;
                    index = mid;
                }else right = mid - 1;
            }

            sum += (index - i);
        }

        sb.append(sum).append("\n");
        System.out.println(sb);
        
    }
}