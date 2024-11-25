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
        int m = Integer.parseInt(st.nextToken());

        // n일동안 자신이 사용할 금액을 계산
        // m번만 통장에서 돈을 빼서 사용


        int[] arr = new int[n];
        int left = 1;
        int right = 1_000_000_000;
        int answer = 1_000_000_000;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
            left = Math.max(left, num);
        }


        while(left <= right){
            int mid = (left + right)/2;
            int temp = 0;
            int count = 0;

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if(temp < arr[i]){
                    count ++;
                    temp = mid;
                }
                temp -= arr[i];

                if(temp < 0) flag = false;
            }

            if(count <= m && flag){
                right = mid - 1;
                answer = Math.min(answer, mid);
            }else {
                left = mid + 1;

            }
        }
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}