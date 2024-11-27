import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] arr;
    static boolean[] visited;
    static int[] used;
    static String max = "0";
    static String min = "9876543210";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            arr[i] = s;
        }
        used = new int[n + 1];

        visited = new boolean[10];

        backtrack(0, "");

        sb.append(max).append("\n");
        sb.append(min).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int depth, String s){
        if(depth == n + 1){
            if(check()){
                long num = Long.parseLong(s);
                if(num > Long.parseLong(max)){
                    max = s;
                }

                if(num < Long.parseLong(min)){
                    min = s;
                }

            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!visited[i]){
                visited[i] = true;
                used[depth] = i;
                backtrack(depth + 1, s + i);
                visited[i] = false;
            }
        }

    }

    static boolean check(){
        for (int i = 0; i < n; i++) {
            int a = used[i];
            int b = used[i + 1];

            String s = arr[i];

            if(s.equals("<")){
                if(a > b) return false;
            }else{
                if(a < b) return false;
            }
        }

        return true;
    }
}