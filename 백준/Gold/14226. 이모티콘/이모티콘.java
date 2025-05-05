import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int n;
    static class Emo{
        int clipboard;
        int total;
        int time;

        public Emo(int clipboard, int total, int time){
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[1001][1001]; // 클립보드, 현재 개수

        int answer = bfs();
        sb.append(answer).append("\n");
        System.out.println(sb);

    }
    static int bfs(){
        ArrayDeque<Emo> deque = new ArrayDeque<>();
        visited[0][1] = true;
        deque.add(new Emo(0, 1, 0));

        while (!deque.isEmpty()){
            Emo now = deque.pollFirst();


            int cb = now.clipboard;
            int total = now.total;
            int time = now.time;

            if(total == n)  return time;

            // 복사
            if(!visited[total][total]){
                visited[total][total] = true;
                deque.addLast(new Emo(total, total, time + 1));
            }

            // 붙여넣기
            if(cb != 0 &&  total + cb <= 1000 &&!visited[cb][total + cb]){
                visited[cb][total + cb] = true;
                deque.addLast(new Emo(cb, total + cb, time + 1));
            }

            // 하나 삭제
            if(total > 0 && !visited[cb][total - 1]){
                visited[cb][total - 1] = true;
                deque.addLast(new Emo(cb, total - 1, time + 1));
            }

        }


        return -1;
    }
}
