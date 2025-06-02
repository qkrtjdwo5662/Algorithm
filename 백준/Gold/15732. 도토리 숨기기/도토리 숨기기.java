import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 상자의 개수
        int k = Integer.parseInt(st.nextToken()); // 규칙의 개수
        int d = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < k; i++) { // 10_000
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작 상자 NUM
            int b = Integer.parseInt(st.nextToken()); // 끝 상자 NUM
            int c = Integer.parseInt(st.nextToken()); // 간격

            min = Math.min(min, a);
            max = Math.max(max, b);
            list.add(new int[]{a, b, c});
            // a ~ b까지의 상자 번호가 있는데 c의 간격으로 있음
            // 도토리의 개수는 최대 10억개까지
            // 1 2 3 4 5 6 7 8 9 10
            // 1 0 1 0 1 0 1 1 0 0
            // 1 1 2 2 3 3 4 5 5 5
        }


        int left = min;
        int right = max;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < list.size(); i++) {
                int[] now = list.get(i);
                int start = now[0];
                int end = now[1];
                int range = now[2];


                if(mid < start) continue;

                if(mid > end){
                    count += ((end - start) / range) + 1;
                    continue;
                }

                count += ((mid - start) / range) + 1;

            }

            if(count >= d) {
                right = mid - 1;
                answer = mid;
            }else left = mid + 1;
        }

        System.out.println(answer);
    }
}