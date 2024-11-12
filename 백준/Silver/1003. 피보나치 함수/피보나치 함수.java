import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        int[] zeroCount = new int[41];
        int[] oneCount = new int[41];

        zeroCount[0] = 1;
        oneCount[1] = 1;

        zeroCount[2] = 1;
        oneCount[2] = 1;

        for (int i = 3; i < 41; i++) {
            zeroCount[i] = zeroCount[i-1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i-1] + oneCount[i-2];
        }

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            sb.append(zeroCount[num]).append(" ").append(oneCount[num]).append("\n");
        }
        System.out.println(sb);
    }
}