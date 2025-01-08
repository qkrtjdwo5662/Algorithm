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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 3; j < n; j++) {

                int sumA = arr[i] + arr[j];

                int left = i + 1;
                int right = j - 1;

                while(left <= right){
                    int sumB = arr[left] + arr[right];

                    min = Math.min(Math.abs(sumA - sumB), min);

                    if(sumB > sumA) right --;
                    else left ++;
                }
            }
        }

        sb.append(min).append("\n");
        System.out.println(sb);
    }
}
