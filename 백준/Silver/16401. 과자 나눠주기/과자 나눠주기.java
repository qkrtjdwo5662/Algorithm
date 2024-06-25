import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int[] cookiesLengthArr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken()); // 조카의 수
        n = Integer.parseInt(st.nextToken()); // 과자의 수

        cookiesLengthArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(st.nextToken());
            cookiesLengthArr[i] = len;
        }
        Arrays.sort(cookiesLengthArr);
        answer = 0;
        bs();

        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static void bs(){
        int left = 1;
        int right = cookiesLengthArr[n - 1];

        while(left <= right){
            int mid = (left + right)/2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                count += cookiesLengthArr[i] / mid;
            }

            if(count >= m){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }

    }
}