import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        Meeting[] meetings = new Meeting[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, (o1, o2) -> {
            return Integer.compare(o1.start, o2.start);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
           Meeting now = meetings[i];

           if(!pq.isEmpty() && pq.peek() <= now.start){
               pq.poll();
           }
           pq.add(now.end);
        }

        sb.append(pq.size()).append("\n");
        System.out.println(sb);
    }
}