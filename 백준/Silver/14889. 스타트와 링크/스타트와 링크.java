import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int n;
    static int[][] info;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        info = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                info[i][j] = num;
            }
        }

        answer = Integer.MAX_VALUE;
        backtrack(0, 0);
        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static void backtrack(int depth, int index){
        if(depth == n/2){
            answer = Math.min(answer, diff());
            return;
        }

        for (int i = index; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    static int diff(){
        int s1 = 0;
        int s2 = 0;

        List<Integer> startGroup = new ArrayList<>();
        List<Integer> linkGroup = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(visited[i]){
               startGroup.add(i);
            }else linkGroup.add(i);
        }

        for (int i = 0; i < n/2 - 1; i++) {
            for (int j = i + 1; j < n/2; j++) {
                int a1 = startGroup.get(i);
                int b1 = startGroup.get(j);

                int a2 = linkGroup.get(i);
                int b2 = linkGroup.get(j);


                s1 += info[a1][b1] + info[b1][a1];
                s2 += info[a2][b2] + info[b2][a2];
            }
        }

        return Math.abs(s1 - s2);
    }

}