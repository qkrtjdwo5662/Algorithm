import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static TreeSet<Integer> list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        sb = new StringBuilder();
        list = new TreeSet<>();
        dfs(0, 0, n, m, 0);

        if(list.size() != 0){
            
            for(int num : list){
                sb.append(num).append(' ');
            }

        }else sb.append(-1);
        System.out.println(sb);
    }
    static boolean isPrime(int num){
        if(num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
    static void dfs(int depth, int count , int n, int m, int sum){
        if(n - depth < m - count) return;
        
        if(count == m){
            if(isPrime(sum)) list.add(sum);
            return;
        }

        if(depth == n){
            return;
        }

        dfs(depth + 1, count ,n, m, sum);
        dfs(depth + 1, count + 1, n, m,sum + arr[depth]);
    }
}
