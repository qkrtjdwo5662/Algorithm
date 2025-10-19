import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int left = 1;
        int right = n;

        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            boolean flag = true;
            int now = 0;
            for (int i = 0; i < m; i++) {
                int num = arr[i];

                int min = num - mid;
                int max = num + mid;

//                System.out.println(min + " " + max + " " + now + " " + mid);
                if(now >= min && now <= max){
                    now = max;
                }else{
                    flag = false;
                    break;
                }
            }

            if(now < n) flag = false;

            if(flag){
                answer = mid;
                right = mid - 1;

            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
