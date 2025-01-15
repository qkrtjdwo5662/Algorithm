import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        List<Integer>[] colorList = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            colorList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int pos = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            colorList[color].add(pos); // 색깔별 위치 넣어줌
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            List<Integer> now = colorList[i];
            Collections.sort(now);
            for (int j = 0; j < now.size(); j++) {
                int dist = 0;

                if(j == 0){
                    dist = now.get(j + 1) - now.get(j);
                }else if(j == now.size() - 1){
                    dist = now.get(j) - now.get(j - 1);
                }else{
                    dist = Math.min(now.get(j) - now.get(j - 1), now.get(j + 1) - now.get(j));
                }

                answer += dist;
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
