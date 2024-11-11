import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i][0] = num;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i][1] = num;
        }

        Arrays.sort(arr ,(o1, o2) -> {
           return  Integer.compare(o1[1], o2[1]);
        });

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (long)arr[i][0] + (long)i * arr[i][1];
        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}