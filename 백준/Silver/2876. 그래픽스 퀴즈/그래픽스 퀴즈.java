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
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[6];  // 각 등급의 최대 연속 길이
        int[] temp = new int[6];  // 현재 등급의 연속 길이
        int maxLength = 0;
        int maxGrade = 0;

        for (int i = 0; i < n; i++) {
            int A = arr[i][0];
            int B = arr[i][1];

            if (A == B) {
                temp[A]++;
                dp[A] = Math.max(dp[A], temp[A]);
                maxLength = Math.max(maxLength, dp[A]);
            } else {
                temp[A]++;
                temp[B]++;
                dp[A] = Math.max(dp[A], temp[A]);
                dp[B] = Math.max(dp[B], temp[B]);
                maxLength = Math.max(maxLength, Math.max(dp[A], dp[B]));
            }

            // 이전 값이 아닌 등급 초기화
            for (int grade = 1; grade <= 5; grade++) {
                if (grade != A && grade != B) {
                    temp[grade] = 0;
                }
            }
        }

        // 가장 낮은 등급을 찾기
        for (int grade = 1; grade <= 5; grade++) {
            if (dp[grade] == maxLength) {
                maxGrade = grade;
                break;
            }
        }

        sb.append(maxLength).append(" ").append(maxGrade).append("\n");
        System.out.println(sb);
    }
}