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

        int t = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                }
            }

            int count = 0;
            Arrays.sort(arr, (o1, o2) -> {
               return Integer.compare(o1[0], o2[0]);
            });

            int min = 100_001;
            for (int i = 0; i < n; i++) {
                if(arr[i][1] < min){
                    count ++;
                    min = arr[i][1];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}
