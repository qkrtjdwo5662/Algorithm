import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st =new StringTokenizer(br.readLine());
        String title = st.nextToken();
        int len = title.length();
        int answer = 0;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            // s와 title의 비교
            int len2 = s.length();

            int[][] dp = new int[len + 1][len2 + 1];

            for (int j = 1; j <= len; j++) {
                for (int k = 1; k <= len2; k++) {
                    if(title.charAt(j - 1) == s.charAt(k - 1)){
                        dp[j][k] = dp[j - 1][k - 1] + 1;
                    }else{
                        dp[j][k] = Math.max(dp[j - 1][k], dp[j][k - 1]);
                    }
                }
            }

            if(dp[len][len2] != title.length()) continue;

            boolean flag = false;

            int count = 0; // 문자열 맞은 개수

            for (int j = 0; j < s.length(); j++) { // 원본

                if(title.charAt(0) == s.charAt(j)){
                    // 앞부분 맞추고 여기서 시작
                    int index = 1;

                    count = 1;

                    int gap = 1;
                    int index2 = j;
                    while(gap < s.length() && count < title.length() && index2 + gap < s.length()){
                        // 갭 사이즈가 s보다는 작게
                        if(title.charAt(index) == s.charAt(index2 + gap)){
                            index ++;
                            index2 = index2 + gap;
                            count ++;
                        }else {
                            gap ++;
                            index = 1;
                            index2 = j;
                            count = 1;
                        }
                    }
                }

                if(count == title.length()) flag = true;
            }

            if(flag) answer++;
        }

        System.out.println(answer);
    }
}
