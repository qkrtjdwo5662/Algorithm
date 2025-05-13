import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = new int[m];
        visited = new boolean[n];
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);
        backtrack(0);
    }

    static void backtrack(int depth){
        if(depth == m){
            int temp = -1;
            boolean flag = true;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
                if(answer[i] >= temp){
                    temp = answer[i];
                }else{
                    flag = false;
                    break;
                }
            }

            if(flag && !set.contains(sb.toString())){
                set.add(sb.toString());
                System.out.println(sb);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
