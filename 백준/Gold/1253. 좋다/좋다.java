import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while(left < right){
                int sum = arr[left] + arr[right];

                if(sum == arr[i]) {
                    if(left != i && right != i){
                        count++;
                        break;
                    }else if(left == i){
                        left++;
                    }else{
                        right --;
                    }
                }
                else if(sum > arr[i]) right --;
                else left ++;
            }
        }

        sb.append(count).append("\n");
        System.out.println(sb);
    }
}