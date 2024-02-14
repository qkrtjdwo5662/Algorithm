import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] record;
    static int[][] result;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = 4;
        for (int i = 0; i < n; i++) {
            record = new int[6][3];
            result = new int[6][3];

            visited = new boolean[6];
            flag = false;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    record[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            pickTwoTeam(0, 1);

            if(flag) sb.append(1).append(" ");
            else sb.append(0).append(" ");
            // 6 C 2

        }
        System.out.println(sb);
    }
    static void pickTwoTeam(int depth, int index){
        if(flag) return;

        if(depth == 5){
            if(check()){
                flag = true;
            }
            return;
        }

        if(index == 6){
            pickTwoTeam(depth + 1, depth + 2);
            return;
        }

        result[depth][0] ++;
        result[index][2] ++;
        pickTwoTeam(depth, index+1);
        result[depth][0] --;
        result[index][2] --;


        result[depth][1] ++;
        result[index][1] ++;
        pickTwoTeam(depth, index+1);
        result[depth][1] --;
        result[index][1] --;

        result[depth][2] ++;
        result[index][0] ++;
        pickTwoTeam(depth, index + 1);
        result[depth][2] --;
        result[index][0] --;
    }

    static boolean check(){

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if(record[i][j] != result[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}