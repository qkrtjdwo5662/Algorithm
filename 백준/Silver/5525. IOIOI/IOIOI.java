import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String pattern = "IOI";
        int answer = 0;
        int count = 0;

        for (int i = 0; i < m - 1; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O') {
                int j = i + 1;
                while (j + 1 < m && s.charAt(j) == 'O' && s.charAt(j + 1) == 'I') {
                    j += 2;
                    count++;
                    if (count == n) {
                        answer++;
                        count--;
                    }
                }
                count = 0; // Reset count if the pattern breaks
                i = j - 1;
            }
        }

        System.out.println(answer);
    }
}