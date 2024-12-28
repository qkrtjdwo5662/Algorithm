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

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arrA = new int[n];
            int[] arrB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n ; i++) {
                int num = Integer.parseInt(st.nextToken());
                arrA[i] = num;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m ; i++) {
                int num = Integer.parseInt(st.nextToken());
                arrB[i] = num;
            }

            Arrays.sort(arrB);

            long answer = 0;
            for (int i = 0; i < n; i++) {

                int num = arrA[i]; // 숫자 하나 꺼내고

                int left = 0;
                int right = m - 1;

                int minNum = 1_000_000_000;
                int minDiff = 1_000_000_000 - 1;

                while(left <= right){
                    int mid = (left + right) / 2;

                    int diff = Math.abs(num - arrB[mid]);

                    if(diff < minDiff){
                        minDiff = diff;
                        minNum = arrB[mid];
                    }else if(diff == minDiff) {
                        if(minNum > arrB[mid]) minNum = arrB[mid];
                    }

                    if(diff == 0) break;

                    if(arrB[mid] < num){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }

                answer += minNum;
            }

            sb.append(answer).append("\n");
        }


        System.out.println(sb);

    }
}
