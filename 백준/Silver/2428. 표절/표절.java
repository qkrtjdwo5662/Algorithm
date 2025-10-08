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
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // n명의 참가자가 솔루션파일을 각자 하나씩 제출했음
        // 채점 결과 발표하기전 표절검사를 실시한다.
        // 모든쌍을 검사하지 않고 두파일이 있을때 작은 파일의 크기가 큰 파일의 크기의 90%보다 클때 검사함

        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            int max = i;

            while(left <= right){
                int mid = (left + right) / 2;
                if(arr[mid] * 9 <= arr[i] * 10){
                    max = mid;
                    left = mid + 1;
                }else right = mid - 1;
            }

            answer += (max - i);
        }

        System.out.println(answer);
    }
}
