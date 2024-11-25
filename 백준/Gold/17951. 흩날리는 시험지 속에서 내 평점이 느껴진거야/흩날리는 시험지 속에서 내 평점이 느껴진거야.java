import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] += arr[i - 1] + num;
        }


        int left = 0;
        int right = 2_000_000;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            int tempIndex = 0;
            int score = arr[n];
            for (int i = 1; i <= n; i++) {
                if(arr[i] - arr[tempIndex] >= mid ) {
                    count++;
                    score = Math.min(score, arr[i] - arr[tempIndex]);
                    tempIndex = i;
                }
            }

            if(count >= k){
                left = mid + 1;
                answer = Math.max(answer, score);
            }else {
                right = mid - 1;
            }

        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}