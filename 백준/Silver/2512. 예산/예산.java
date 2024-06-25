import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int result;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        result = 0;

        bs();
        sb.append(result).append("\n");
        System.out.println(sb);
    }

    static void bs(){
        int left = 0;
        int right = arr[n - 1];

        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(mid < arr[i]){
                    sum += mid;
                }else sum += arr[i];
            }

            if(sum <= m){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
    }
}