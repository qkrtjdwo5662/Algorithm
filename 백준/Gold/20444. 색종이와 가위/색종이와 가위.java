import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // n번의 가위질로 k개를 만들 수 있나?

        long left = 0;
        long right = n - n/2;

        while(left <= right){
            long mid = (left + right) / 2;

            if(((n - mid) + 1) * (mid + 1) == k ){
                System.out.println("YES");
                return;
            }else if(((n - mid) + 1) * (mid + 1) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println("NO");
    }
}