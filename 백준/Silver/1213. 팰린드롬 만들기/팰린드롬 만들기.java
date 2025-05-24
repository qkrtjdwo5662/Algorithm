import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final String message = "I'm Sorry Hansoo";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int[] arr = new int[(int)('Z' - 'A') + 1];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A'] ++;
        }

        // 불가능 조건
        // 주어진 문자열 길이가 짝수 인데 문자열 개수 홀수 있는경우
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) count ++;
        }

        if(s.length() % 2 == 0 && count > 0){
            System.out.println(message);
            return;
        }else if(s.length() % 2 != 0 && count > 1){
            System.out.println(message);
            return;
        }

        char[] answer = new char[s.length()];

        int left = 0, right = s.length() - 1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 2){
                char c = (char) ('A' + i);
                answer[left] = c;
                answer[right] = c;
                arr[i] -= 2;
                left ++;
                right --;

                if(arr[i] >= 2) i --;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                char c = (char) ('A' + i);
                answer[left] = c;
                arr[i] -= 1;
                left ++;
            }
        }

        System.out.println(String.valueOf(answer));
    }
}
