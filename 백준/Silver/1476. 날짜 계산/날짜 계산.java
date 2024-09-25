import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 1;
        int ee = 1;
        int ss = 1;
        int mm = 1;

        while(true){
            if(ee == e && ss == s && mm == m) break;

            answer ++;
            ee ++;
            ss ++;
            mm ++;

            ee = ee % 16;
            if(ee == 0) ee = 1;

            ss = ss % 29;
            if(ss == 0) ss = 1;

            mm = mm % 20;
            if(mm == 0) mm = 1;

        }

        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}