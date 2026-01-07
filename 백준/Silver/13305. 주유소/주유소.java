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

        int[] distance = new int[n];
        int[] value = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1 ; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if(value[i] < min) {
                min = value[i];

            }
            answer += (long)min * distance[i];
        }
        System.out.println(answer);

    }
}
