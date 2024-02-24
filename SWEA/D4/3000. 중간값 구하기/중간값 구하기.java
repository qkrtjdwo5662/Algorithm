import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()); // 공책 처음 입력 수

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int answer = 0;

            maxHeap.add(a);
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(x <= y){
                    maxHeap.add(x);
                    minHeap.add(y);
                }else{
                    maxHeap.add(y);
                    minHeap.add(x);
                }

                if(maxHeap.peek() > minHeap.peek()) {
                    int maxPoll = maxHeap.poll();
                    int minPoll = minHeap.poll();

                    minHeap.add(maxPoll);
                    maxHeap.add(minPoll);
                }
                answer += maxHeap.peek();
                answer = answer % 20171109;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}