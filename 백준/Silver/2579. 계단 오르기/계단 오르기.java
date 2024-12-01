import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 계단이 1개일 경우 처리
        if (n == 1) {
            System.out.println(stairs[0]);
            return;
        }

        // DP 배열 초기화
        int[][] dp = new int[n][3];

        // 첫 번째 계단 초기값 설정
        dp[0][1] = stairs[0]; // 첫 계단 밟음
        dp[0][2] = 0;         // 첫 계단 밟지 않음

        // 두 번째 계단 초기값 설정
        dp[1][1] = stairs[1];         // 두 번째 계단만 밟음
        dp[1][2] = stairs[0] + stairs[1]; // 첫 번째 계단 + 두 번째 계단

        // 점화식 적용
        for (int i = 2; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i]; // 한 칸 건너뛰고 밟음
            dp[i][2] = dp[i - 1][1] + stairs[i];                         // 바로 직전 계단에서 연속으로 밟음
        }

        // 마지막 계단을 반드시 밟는 경우 중 최대값 선택
        int answer = Math.max(dp[n - 1][1], dp[n - 1][2]);
        System.out.println(answer);
    }
}