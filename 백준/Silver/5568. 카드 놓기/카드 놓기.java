import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static boolean[] visited;
    static int[] selected;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        // n개의 카드 중에 k선택

        arr = new int[n];

        selected = new int[k];
        visited = new boolean[n];
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        backtrack(0);

        System.out.println(set.size());
    }

    static void backtrack(int depth){
        if(depth == k){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(selected[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
