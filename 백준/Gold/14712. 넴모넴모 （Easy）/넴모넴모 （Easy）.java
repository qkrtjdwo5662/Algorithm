import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[][] nemo;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nemo = new boolean[n][m];
        answer = 0;
        backtrack(0, 0);
        System.out.println(answer);

    }

    static void backtrack(int y, int x){
        if(x == m){
            y += 1;
            x = 0;
        }

        if( y== n){
            answer++;
            return;
        }

        backtrack(y, x + 1);

        if(can(y, x)){
            nemo[y][x] = true;
            backtrack(y, x + 1);
            nemo[y][x] = false;
        }
    }

    static boolean can(int y, int x){
        if(y ==0 || x== 0) return true;

        if (nemo[y - 1][x] && nemo[y][x - 1] && nemo[y - 1][x - 1]) return false;
        return true; // 네모가 안되기 위한
    }

}