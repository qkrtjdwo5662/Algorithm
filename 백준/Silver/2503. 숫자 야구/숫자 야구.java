import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Ques{
        int strike;
        int ball;
        int num;

        public Ques(int num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static Ques[] quesArr;
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        quesArr = new Ques[n];

        for (int i = 0; i < n; i++) {
            st =  new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            Ques ques = new Ques(num, strike, ball);
            quesArr[i] = ques;
        }

        arr = new int[3];
        visited = new boolean[10];
        answer = 0;

        backtrack(0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int depth){
        if(depth == 3){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(arr[i]);
            }
            if(check(sb.toString())) answer ++;

            return;
        }

        for (int i = 1; i < 10 ; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(String num){
        for (int i = 0; i < n; i++) {
            Ques ques = quesArr[i];
            String compare = String.valueOf(ques.num);

            int ballCount = 0;
            int strikeCount = 0;

            for (int j = 0; j < 3; j++) {
                if(num.contains(String.valueOf(compare.charAt(j)))){
                    ballCount ++;
                }

                if(num.charAt(j) == compare.charAt(j)){
                    ballCount --;
                    strikeCount ++;
                }

            }

            if(strikeCount == ques.strike && ballCount == ques.ball) continue;
            else return false;
        }

        return true;
    }
}