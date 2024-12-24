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
        int[] arr = new int[n + 1];
        int[] result = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // 4
        // 2 1 1 0
        // 1보다 큰거 왼쪽에 위치한 개수 2개 -> 1의 위치는 3이 됨
        // 2보다 큰거 왼쪽에 위치한 개수 1개 -> 2의 위치는 2
        // 3보다 큰거 왼쪽에 위치한 개수 1개 -> 3의 위치는 4
        // 4보다 큰거 왼쪽에 위치한 개수 0개 -> 4의 위치는 1
        // 4 2 1 3

        // 5
        // 0 0 0 0 0
        // 1보다 큰거 왼쪽에 위치한 개수 0개 -> 1의 위치 1
        // 2보다 큰거 왼쪾에 위치한 개수 0개 -> 2의 위치 2
        // 3보다 큰거 왼쪽에 위치한 개수 0개 -> 3의 위치 3

        // 6
        // 5 4 3 2 1 0
        // 1보다 큰거 왼쪽에 위치한 개수 5개 -> 1의 위치 6
        // 2보다 큰거 왼쪽에 위치한 개수 4개 -> 2의 위치 5


        // 7
        // 6 1 1 1 2 0 0
        // 1보다 큰거 왼쪽에 위치한 개수 6개 -> 1의 위치 7
        // 2보다 큰거 왼쪽에 위치한 개수 1개 -> 2의 위치 2
        // X2XXXX1
        // 3보다 큰거 왼쪽에 위치한 개수 1개 -> 3의 위치 3
        // 4보다 큰거 왼쪽에 위치한 개수 1개 -> 4의 위치 4
        // X234XX1
        // 5보다 큰거 왼쪽에 위치한 개수 2개 -> 5의 위치 6
        // 6보다 큰거 왼쪽에 위치한 개수 0개 -> 6의 위치 1
        // 6234751

        for (int i = 1; i <= n; i++) {
            int count = 0;
            int num = arr[i];
            for (int j = 1; j <= n ; j++) {
                if(result[j] == 0) count ++;

                if(count == num + 1 && result[j] == 0) result[j] = i;
            }
            
        }

        for (int i = 1; i <= n ; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

    }
}