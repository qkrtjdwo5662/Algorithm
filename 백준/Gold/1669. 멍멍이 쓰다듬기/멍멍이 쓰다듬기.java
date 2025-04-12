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

        int diff = y - x;

        int minSqrt = (int)Math.sqrt(diff);

        if(diff == 0){
            System.out.println(0);
            return;
        }

        if(Math.pow(minSqrt, 2) == diff){
            sb.append(minSqrt * 2 - 1).append("\n");
        }else{
            // 제곱 수 뺀 나머지
            diff -= Math.pow(minSqrt, 2);

            if(diff > minSqrt) sb.append(minSqrt * 2 + 1).append("\n");
            else sb.append(minSqrt * 2).append("\n");
        }

        System.out.println(sb);
    }
}
