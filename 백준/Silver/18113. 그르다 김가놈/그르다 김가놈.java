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
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] >= 2 * k) arr[i] -= 2*k; // 양쪽다
            else if(arr[i] <= 2 * k && arr[i] > k) arr[i] -= k; // 한쪽만
            else if(arr[i] <= k) arr[i] = -1; // 폐기
        }

        int left = 1;
        int right = 1_000_000_000;

        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] == -1) continue; // 폐기
                sum += arr[i] / mid;
            }

            if(sum >= m){ // 자른개수가 최소개수보다 더많으면
                answer = mid;
                left = mid + 1;
            }else right = mid - 1;
        }
        if(answer == 0){
            System.out.println(-1);
        }else System.out.println(answer);

    }
}
