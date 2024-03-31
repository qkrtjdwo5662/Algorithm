import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int t;
    static boolean[] visited;
    static final int maxY = 200_000;
    static ArrayList<Integer>[] rock;
    static Map<Integer, int[]> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        rock = new ArrayList[t + 1];

        for (int i = 0; i <= t; i++) {
            rock[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            rock[y].add(x);

        }

        for (int i = 0; i <= t; i++) {
            Collections.sort(rock[i]);
        }
        int answer = bfs();

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    private static int bfs() {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{0, 0, 0});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            int nx = now[0];
            int ny = now[1];
            int d = now[2];
            if(ny == t) return d;

            for (int i = ny -2; i <= ny + 2; i++) {
                if(i < 0 || i> t) continue;

                for (int j = 0; j < rock[i].size(); j++) {
                    int x = rock[i].get(j);

                    if(nx -2 <= x && nx + 2 >= x){
                        deque.addLast(new int[]{x, i, d + 1});
                        rock[i].remove(j);
                        j --;
                    }
                }
            }
        }

        return -1;
    }
}