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

        int min = k*(k + 1)/2;
        if(min > n){ // 최소 합보다 낮으면 -1
            sb.append(-1).append("\n");
        }else{
            int answer = k-1;

            int remain = n - min;

            if(remain % k > 0) answer++;
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}