import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int s;
    public static int[] arr;
    public static boolean[] visited;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        answer = 0;
        dfs(0, 0);
        if(s == 0) answer -=1;
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    public static void dfs(int index, int sum){
        if(index == n){
            if(sum == s){
                answer++;
            }
            return;
        }

        dfs(index+1, sum + arr[index]);
        dfs(index+1, sum);


    }
}

