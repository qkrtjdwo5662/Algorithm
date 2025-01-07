import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                pq.add(num);
            }
        }

        int index = 1;
        while(index < n){
            pq.poll();
            index ++;
        }

        sb.append(pq.peek()).append("\n");
        System.out.println(sb);

    }
}
