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

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long num = Long.parseLong(st.nextToken());

            long answer = findDecimal(num);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static long findDecimal(long num){
        if(num == 0) return 2;
        if(num == 1) return 2;
        if(num == 2) return 2;

        for (long i = num; i < Long.MAX_VALUE; i++) {
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }

            if(!flag) return i;
        }

        return -1;
    }
}