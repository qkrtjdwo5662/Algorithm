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

            int[] A = new int[n];
            int[] countArr = new int[n];

            int[] B = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                A[i] = num;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                B[i] = num;
            }

            Arrays.sort(A);
            Arrays.sort(B);
            int maxCount = 0;
            for (int i = m - 1; i >= 0; i--) {
                if(B[i] < A[n - 1]) maxCount ++;
            }

            countArr[n - 1] = maxCount;

            int index = n - 2;
            
            if(n - 2 >= 0){
                int count = maxCount;

                while(index >=0 && A[index] > B[0] && count > 0 && count <= m ){
                    if(A[index] <= B[count - 1]){
                        count --;
                    }else{
                        countArr[index] = count;
                        index --;
                    }
                }
            }

            int answer = 0;
            for (int i = n - 1; i >=0 ; i--) {
                if(countArr[i] == 0){
                    break;
                }
                answer += countArr[i];
            }

            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }
}