import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        // 뒤에서 탐색
        // 끝이 어떤 색이고, 얼마나 연속되어있는가
        // 나머지는 개수만 센다.

        char c = s.charAt(n - 1);

        int initCount = 1; // 뒤의 연속적 공 개수

        int blueCount = 0;
        int redCount = 0;

        boolean flag = true;

        if(c == 'R') redCount ++;
        else blueCount ++;
        for (int i = n - 2; i >= 0 ; i--) {
            if(s.charAt(i) == c){
                if(flag) initCount ++;
            }else flag = false;

            if(s.charAt(i) == 'R') redCount ++;
            else blueCount ++;
        }


        if(c == 'R') redCount -= initCount;
        else blueCount -= initCount;

        sb.append(Math.min(redCount, blueCount));
        System.out.println(sb);
    }
}
