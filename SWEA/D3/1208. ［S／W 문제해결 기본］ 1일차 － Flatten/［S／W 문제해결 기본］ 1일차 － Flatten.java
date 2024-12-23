import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static final int WIDTH = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < WIDTH; i++) {
                int num = Integer.parseInt(st.nextToken());

                maxHeap.add(num);
                minHeap.add(num);
            }

            for (int i = 0; i < n; i++) {
                int max = maxHeap.poll();
                int min = minHeap.poll();

                max -= 1;
                min += 1;

                maxHeap.add(max);
                minHeap.add(min);
            }

            int answer = Math.abs(maxHeap.peek() - minHeap.peek());
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}