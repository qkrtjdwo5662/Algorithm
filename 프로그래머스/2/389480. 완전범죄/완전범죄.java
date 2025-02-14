import java.util.*;

class Solution {
    static final int INF = 987654321;

    public int solution(int[][] info, int n, int m) {
        int size = info.length;

        // DP 상태 저장: (B 누적 값, A 최소 값)
        Map<Integer, Integer>[] dp = new HashMap[size];

        for (int i = 0; i < size; i++) {
            dp[i] = new HashMap<>();
        }

        // 초기 상태 설정
        if (info[0][0] < n) {
            dp[0].put(0, info[0][0]); // (B 값, A 최소 값)
        }
        if (info[0][1] < m) {
            dp[0].put(info[0][1], 0); // (B 값, A 최소 값)
        }

        // DP 갱신
        for (int i = 1; i < size; i++) {
            int numA = info[i][0];
            int numB = info[i][1];

            Map<Integer, Integer> newDP = new HashMap<>();

            // 기존 DP 값 업데이트 (A 선택)
            for (Map.Entry<Integer, Integer> entry : dp[i - 1].entrySet()) {
                int prevB = entry.getKey();
                int prevA = entry.getValue();

                // A 선택
                int newA = prevA + numA;
                if (newA < n && prevB < m) {
                    newDP.put(prevB, Math.min(newDP.getOrDefault(prevB, INF), newA));
                }

                // B 선택
                int newB = prevB + numB;
                if (prevA < n && newB < m) {
                    newDP.put(newB, Math.min(newDP.getOrDefault(newB, INF), prevA));
                }
            }

            // 현재 DP 값 갱신
            dp[i] = newDP;
        }

        // 🔹 최솟값 찾기
        int answer = INF;
        for (int val : dp[size - 1].values()) {
            answer = Math.min(answer, val);
        }

        return (answer == INF) ? -1 : answer;
    }
}