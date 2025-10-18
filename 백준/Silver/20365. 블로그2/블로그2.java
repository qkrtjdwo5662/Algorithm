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


        char prev = '0';
        int blue = 0, red = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if(c != prev && c == 'R') red ++;
            else if(c != prev && c == 'B') blue ++;

            prev = c;
        }

        System.out.println(Math.min(red, blue) + 1);
    }

}
