import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] board;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            board = new int[n][n];
            visited = new boolean[n];
            answer = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }

            divide(0, 0);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);


    }
    static void sum(){
        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if(visited[i] && visited[j]){
                    totalA += board[i][j];
                    totalA += board[j][i];
                }

                if(!visited[i] && !visited[j]){
                    totalB += board[i][j];
                    totalB += board[j][i];
                }
            }
        }
        int abs = Math.abs(totalA - totalB);
        answer = Math.min(answer, abs);

    }
    static void divide(int depth, int index){
        if(depth == n/2){
            sum();
            return;
        }

        for (int i = index; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                divide(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}