import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][10];

        arr[0][0] = 10;
        for (int i = 0; i < 10; i++) {
            arr[0][i] = arr[0][0] - i;
        }


        for (int i = 1; i < n ; i++) {
            int sum = 0;

            for (int j = 0; j < 10; j++) {
                sum += (arr[i - 1][j] % MOD);
            }
            arr[i][0] = sum % MOD;
            for (int j = 1; j < 10 ; j++) {
                sum -= arr[i - 1][j - 1];
                arr[i][j] = sum % MOD;
            }
        }


        System.out.println(arr[n - 1][0]);
    }
}
