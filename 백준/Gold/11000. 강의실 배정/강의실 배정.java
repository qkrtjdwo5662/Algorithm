import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Lecture {
        int start;
        int end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

//        @Override
//        public int compareTo(Lecture l) {
//            if(this.start < l.start){
//                return this.start - l.start;
//            }else if(this.start > l.start){
//                return l.start - this.start;
//            }else{
//                return this.end - l.end;
//            }
//        }
    }
    static Lecture[] lectureArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        lectureArr = new Lecture[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Lecture lecture = new Lecture(start, end);
            lectureArr[i] = lecture;
        }
//        Arrays.sort(lectureArr);
        Arrays.sort(lectureArr, (o1, o2) -> {
            if(o1.start == o2.start){
                return Integer.compare(o1.end, o2.end);
            } else{
                return Integer.compare(o1.start, o2.start);
            }
        });

        pq.add(lectureArr[0].end);

        for (int i = 1; i < n; i++) {
            Lecture now = lectureArr[i];

            if(pq.peek() <= now.start){
                pq.poll();
            }

            pq.add(now.end);
        }

        sb.append(pq.size()).append("\n");
        System.out.println(sb);
    }
}