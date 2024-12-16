import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int status = Integer.parseInt(st.nextToken()); // m or wm
            int num = Integer.parseInt(st.nextToken()); // num
            go(status, num);
        }

        int index = 20;
        for (int i = 1; i <= n ; i++) {
            sb.append(arr[i]).append(" ");
            if(i % index == 0) sb.append("\n");
        }
        sb.append("\n");
        System.out.println(sb);

    }

    static void go(int status, int num){
        if(status == 1){ // m
            int index = num;
            while(index <= n){
                if(arr[index] == 0){
                    arr[index] = 1;
                }else arr[index] = 0;

                index += num;
            }
        }else if(status == 2){ // wm
            int index = num;
            int a = 1;
            int s = 0;
            int e = 0;

            while(index + a <=n && index - a > 0){
                if(arr[index + a] != arr[index - a]) break;

                a++;
            }

            a--;
            s = index - a;
            e = index + a;
            for (int i = s; i <= e ; i++) {
                if(arr[i] == 0){
                    arr[i] = 1;
                }else arr[i] = 0;
            }
        }
    }
}