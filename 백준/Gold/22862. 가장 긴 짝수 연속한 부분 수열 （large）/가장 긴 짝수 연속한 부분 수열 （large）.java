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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int left = 0;
        int right = 0;

        int count = 0;

        int answer = 0;
        while(right < n){
            if(count > k){
                if(arr[left] % 2 == 1) count --;
                left ++;
            }else{
                if(arr[right] % 2 == 1) count ++;
                right ++;
            }

            answer = Math.max(answer, right - left - count);

        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}