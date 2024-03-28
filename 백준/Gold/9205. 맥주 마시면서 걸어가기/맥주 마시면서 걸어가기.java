import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> list;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());


        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int startX = -1;
            int startY = -1;

            int endX = -1;
            int endY = -1;
            list = new ArrayList<>();
            visited = new boolean[n];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(i == 0){
                    startX = x;
                    startY = y;
                }else if(i == n + 1){
                    endX = x;
                    endY = y;
                }else{
                    list.add(new int[]{x, y});
                }
            }

            if(bfs(startX, startY, endX, endY)){
                sb.append("happy").append("\n");
            }else{
                sb.append("sad").append("\n");
            }
        }
        System.out.println(sb);
    }
    static boolean bfs(int startX, int startY, int endX, int endY){
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.addLast(new int[]{startX, startY});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            int diff = Math.abs(now[0] - endX) + Math.abs(now[1] - endY);
            if(diff <= 1000) return true;

            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    int[] store = list.get(i);
                    diff = Math.abs(now[0] - store[0]) + Math.abs(now[1] - store[1]);

                    if(diff <= 1000){
                        visited[i] = true;
                        deque.addLast(store);
                    }
                }
            }
        }

        return false;
    }

}