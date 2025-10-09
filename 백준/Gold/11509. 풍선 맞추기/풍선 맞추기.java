import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int[] cnt = new int[MAX + 2];

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(cnt[num + 1] > 0){
                cnt[num + 1] --;
            }
            cnt[num] ++;
        }
        int answer = 0;
        for(int item : cnt) answer += item;

        System.out.println(answer);
    }
}
