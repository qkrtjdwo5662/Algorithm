import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] broken;
    static int len;
    static int n;
    static int answer;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        broken = new boolean[10];
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int now = 100;
        answer = Math.abs(n - now);
        len = String.valueOf(n).length();
        flag = true;
        if(m == 0){
            moveChanel(0, 0);

        }else{
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
            moveChanel(0, 0);
        }
        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static void moveChanel(int now, int depth){
        if(depth == 6){
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!broken[i]){
                int next = now * 10 + i;
                int count = String.valueOf(next).length() + Math.abs(next - n);
                answer = Math.min(answer, count);
                moveChanel(next, depth + 1);
            }
        }


    }
}