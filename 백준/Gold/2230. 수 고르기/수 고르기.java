import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // N개의 카드 중에 2개의 카드를 골라라
        // 카드에 적힌 숫자의 차이가 M이상인 것 중 가장 작은 것
        // 투포인터

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        // 오른쪽 이동 기준 해당 수의 차이가 M보다 작으면
        while(right < n){
//            System.out.println(right + " " + left);
            int diff = Math.abs(arr[right] - arr[left]);

            if(diff < m) right ++;
            else{
                answer = Math.min(answer, diff);
                left ++;
            }

            if(left == right) {
                right ++;
            }
        }

        System.out.println(answer);
    }
}
