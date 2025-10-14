import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 김밥 꼬다리 자를거임
        // 양쪽 균일 K만큼 잘라낼건데 2K보다 작으면 꼬다리 다자르고 나면 아무것도 없으니까 한쪽만 자름
        // 꼬다리 잘라낸 김밥은 P로 다시 일정하게 자름 P로 자른 김밥 M개
        // P를 최대한 길게 자르고 싶으면 ?

        int n = Integer.parseInt(st.nextToken()); // 손질해야하는 김밥 개수
        int k = Integer.parseInt(st.nextToken()); // 꼬다리 길이
        int m = Integer.parseInt(st.nextToken()); // 김밥 최소개수

        int max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, arr[i]);
        }

        // n개를 꼬다리 k길이의 꼬다리만 잘라서 김밥 최소개수 보다 크게 어떻게 길이를 자르겠냐
        int left = 1;
        int right = 1_000_000_000;

        int answer = -1;
        while(left <= right){
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                int num = arr[i];

                // 꼬다리보다 작으면 폐기
                if(num <= k) continue;

                if(num < 2 * k) num -= k;
                else{
                    num -= 2 * k;
                }

                count += (num / mid);
            }

            if(count >= m){
                answer = mid; // 가능한 후보
                left = mid + 1;
            }else right = mid - 1;

        }

        System.out.println(answer);
    }
}
