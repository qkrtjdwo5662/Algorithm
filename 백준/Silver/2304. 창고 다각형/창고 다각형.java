import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

           list.add(new int[]{l, h});
        }

        list.sort((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        // x좌표로 정렬

        int len = list.get(list.size()-1)[0];

        int maxH = 0;
        int maxIdx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] > maxH) {
                maxH = list.get(i)[1];
                maxIdx = i;
            }
        }

        int prevX = 0;
        int max = 0;

        int answer = 0;
        for (int i = 0; i <= maxIdx; i++) {
            int[] now = list.get(i);

            // 높이 갱신 && 값 누적
            if(max <= now[1]) {
                answer += (now[0] - prevX) * max;
                prevX = now[0];
                max = now[1];
            }


        }



        max = 0;
        prevX = list.get(list.size()-1)[0];
        for (int i = list.size() - 1; i >=maxIdx; i--) {
            int[] now = list.get(i);

            // 높이 갱신 && 값 누적
            if(max <= now[1]){
                answer += (prevX - now[0]) * max;
                prevX = now[0];
                max = now[1];
            }
        }

        answer += maxH;

        System.out.println(answer);
    }
}
