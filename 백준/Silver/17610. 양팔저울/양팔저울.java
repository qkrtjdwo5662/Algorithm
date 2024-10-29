import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static Set<Integer> set;
    static int s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        set = new HashSet<>();
        s = 0;

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
            s += arr[i];
        }
        go(0, 0);
        System.out.println(s - set.size());
    }

    static void go(int now, int depth){
        if(depth == n){
            if(now > s || now <= 0) return;
            else set.add(now);

            return;
        }

        go(now + arr[depth], depth + 1);
        go(now, depth + 1);
        go(now - arr[depth], depth + 1);

    }
}