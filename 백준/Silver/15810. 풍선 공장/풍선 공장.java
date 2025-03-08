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

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }

        long left = 1;
        long right = max * m;
        long answer = 0;
        while(left <= right){
            long mid = (left + right) / 2;

            long count = 0;

            for (int i = 0; i < n; i++) {
                count += mid/arr[i];
            }

            if(count >= m){ // 더 많으면? 줄일 수 있음 -> 조건은 일단 부합함
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}
