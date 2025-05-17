import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[][] dp;
    static int MAX = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        arr = new int[n]; // 양팔 저울 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] arr2 = new int[m]; // 찾아야하는 추

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr2[i] = num;
        }

        dp = new int[n + 1][40001];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 40000 ; j++) {
                if (dp[i][j] == 1) {
                    dp[i + 1][j] = 1; // 추를 사용하지 않을 때
                    if (j + arr[i] <= 40000) {
                        dp[i + 1][j + arr[i]] = 1; // 오른쪽에 놓았을 때
                    }
                    if (Math.abs(j - arr[i]) <= 40000) {
                        dp[i + 1][Math.abs(j - arr[i])] = 1; // 왼쪽에 놓았을 때
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if(dp[n][arr2[i]] == 0){
                sb.append("N").append(" ");
            }else sb.append("Y").append(" ");
        }

        System.out.println(sb);
    }

}
