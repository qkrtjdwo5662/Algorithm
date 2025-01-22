
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc ; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                }
            }
            visited = new boolean[n];

            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }
    static void dfs(int depth, int count){
        if(count == n/2){
            answer = Math.min(cal(), answer);
            return;
        }

        if(depth == n){
            return;
        }

        visited[depth] = true;
        dfs(depth + 1, count + 1);
        visited[depth] = false;
        dfs(depth + 1, count);
    }

    static int cal(){
        int[] A = new int[n/2];
        int[] B = new int[n/2];

        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < n; i++) {
            if(visited[i]){
                A[indexA] = i;
                indexA ++;
            }else{
                B[indexB] = i;
                indexB ++;
            }
        }

        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < n/2 - 1; i++) {
            int a1 = A[i];
            int b1 = B[i];
            for (int j = i + 1; j < n/2 ; j++) {
                int a2 = A[j];
                int b2 = B[j];

                totalA += map[a1][a2] + map[a2][a1];
                totalB += map[b1][b2] + map[b2][b1];
            }
        }

        return Math.abs(totalA - totalB);
    }
}
