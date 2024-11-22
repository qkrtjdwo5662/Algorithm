import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 보석 종류

        int[] arr = new int[m];

        int left = 1;
        int right = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            right = Math.max(right, num);
            arr[i] = num;
        }

        int answer = 0;

        while(left <= right){ // 30
            int mid = (left + right) / 2; // 이걸 max값으로
            int count = 0;

            for (int i = 0; i < m; i++) { // 300_000
                if(arr[i] % mid == 0) count += arr[i] / mid;
                else count += (arr[i] / mid) + 1;
            }

            if(count > n){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = mid;
            }


        }

        System.out.println(answer);
    }
}