import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] friends;
    static boolean[] visited;
    static int[] arr;
    static int max;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // A와 B가 친한친구, B와 C가 친한친구라고 A와 C가 무조건 친한 친구는 아님
        // 가운데를 제외한 나머지 친구들은 서로 친한친구여야 한다? -> X
        // 일단 쭉 배치 해놓고, 펠린드롬 짝짓기?

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        friends = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            friends[u - 1][v - 1] = true;
            friends[v - 1][u - 1] = true;
        }

        visited = new boolean[n];
        arr = new int[n];
        max = 0;

        backtrack(0);

        int result = max * 2;
        if(result < n) result += 1;
        System.out.println(result);
    }
    static void backtrack(int count){
        int first = -1;

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                first = i;
                break;
            }
        }

        if(first == -1){
            max = Math.max(max, count);
            return;
        }

        visited[first] = true;
        backtrack(count);
        visited[first] = false;

        for (int i = first + 1; i < n; i++) {
            if(!visited[i] && friends[first][i]){
                visited[first] = true;
                visited[i] = true;
                backtrack(count + 1);
                visited[first] = false;
                visited[i] = false;
            }
        }
    }

}
