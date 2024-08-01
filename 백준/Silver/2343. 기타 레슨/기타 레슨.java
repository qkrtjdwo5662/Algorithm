import java.io.*;
import java.util.*;

public class Main {

    // 이진탐색에서 가장 중요한 것은 탐색할 범위를 설정하는 것인 듯!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        int answer = 0;

        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            total += A[i];
        }

        int startIndex = 0; // 이미 정렬된 데이터를 받았음, 블루레이의 최소 크기는 배열의 가장 큰 값보다 최소 같아야 함.
        int endIndex = total;
        for (int i = 0; i < n; i++) {
            startIndex = Math.max(A[i], startIndex);
        }
        while (startIndex <= endIndex) {
            int midValue = (startIndex + endIndex) / 2;
            // 처음부터 계속 더해가면서 합이 midValue보다 커지면 count++
            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                if (sum + A[i] > midValue) {
                    count++;
                    sum = A[i];
                } else {
                    sum += A[i];
                }
            }
            // 그러다가 count 수가 m의 값과 같으면 return
            // count와 m을 비교하여 포인터 조정
            if (count <= m) { // count == m 일 때 바로 return하지 않는 이유는, 블루레이의 최솟값을 찾아야 하기 때문
                // 따라서 끝까지 이분탐색!
                answer = midValue;
                endIndex = midValue - 1;
            } else {
                startIndex = midValue + 1;
            }
        }
        System.out.println(answer);
    }
}