import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int n;
    static int[][] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 이닝

        arr = new int[n][9]; // 이닝 당 선수 기록

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        visited = new boolean[9];

        answer = 0;
        backtrack(0, new int[9]);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
    static void game(int inning, int out, int score, int[] base, int[] players, int turn){
        if(out == 3){
            if(inning + 1 >= n){
                answer = Math.max(answer, score);
                return;
            }else{
                inning = inning + 1;
                out = 0;
                base = new int[4];
            }
        }

        if(arr[inning][players[turn]] == 0){
            game(inning , out + 1, score, base, players,(turn  + 1) % 9 );
        }else if(arr[inning][players[turn]] <= 4){
            score = hit(base, arr[inning][players[turn]], score);
            game(inning, out,  score, base, players,(turn  + 1) % 9 );
        }



    }

    static int hit(int[] base, int num, int score){
        if(num < 4){ // 안타
            for (int i = 3; i >= 1; i--) {
                if(base[i] == 1){
                    if(i + num >=  4){
                        score += 1;
                    }else{
                        base[i + num] = 1;
                    }
                    base[i] = 0;
                }
            }
            base[num] = 1;
        }else{ // 홈런
            int count = 0;

            for (int i = 1; i <= 3; i++) {
                if(base[i] == 1){
                    count ++;
                    base[i] = 0;
                }
            }

            count ++;
            score += count;
        }

        return score;

    }
    static void backtrack(int depth, int[] players){
        if(depth == 9){
            game(0, 0, 0, new int[4], players, 0);
//            System.out.println(Arrays.toString(players));
            return;
        }

        for (int i = 0; i < 9; i++) {
            if(depth == 3 && i!= 0){
                continue;
            }

            if(!visited[i]){
                visited[i] = true;
                players[depth] = i;
                backtrack(depth + 1, players);
                players[depth] = 0;
                visited[i] = false;
            }

        }
    }
}