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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] lis = new int[n];
        lis[0] = arr[0];
        int max = 1;

        for (int i = 1; i < n; i++) {
            int key = arr[i];

            if(lis[max -1] < key){
                max ++;
                lis[max - 1] = key;
            }else{
                int low = 0;
                int high = max;

                while(low < high){
                    int mid = (low + high) /2;

                    if(lis[mid] < key){
                        low = mid + 1;
                    }else high = mid;
                }

                lis[low] = key;
            }


        }
        sb.append(max).append("\n");
        System.out.println(sb);
    }
}