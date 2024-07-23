import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String[] arr = new String[H];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            arr[i] = s;
        }


        for (int i = 0; i < N; i++) {
            char c = '?';
            loop:
            for (int j = 0; j < H; j++) {
                for (int k = i * W; k < (i+1) * W; k++) {
                    if(arr[j].charAt(k) != '?'){
                        c = arr[j].charAt(k);
                        continue loop;
                    }
                }
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}