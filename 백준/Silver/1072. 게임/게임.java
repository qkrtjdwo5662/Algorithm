import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 1_000_000_000;
        int answer = -1;
        long init = ((long)y * 100)/x;
        
        while(left <= right){
            int mid = (left + right)/2;

            long plus = ((long)(y + mid) * 100 / (x + mid));

            if(init >= plus){
                left = mid + 1;
            }else {
                right = mid - 1;
                answer = mid;
            }
        }

        if(answer == -1){
            sb.append(-1).append("\n");
        }else sb.append(answer).append("\n");

        System.out.println(sb);
    }
}