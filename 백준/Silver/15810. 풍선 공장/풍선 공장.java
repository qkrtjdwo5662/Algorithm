import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken()); // 스태프의 수
        int m = Integer.parseInt(st.nextToken()); // 만들고자 하는 풍선의 개수

        int[] staff = new int[n];

        st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            staff[i] = num;
            min = Math.min(min, num);
        }

        long left = 0;
        long right = (long) min * m;

        while(left + 1 < right){
            long center = (left + right) / 2;
            long balloon = 0;

            for (int i = 0; i < n; i++) {
                balloon += (center / staff[i]);
            }

            if(balloon >= m){
                right = center;
            }else{
                left = center;
            }
        }

        sb.append(right).append("\n");
        System.out.println(sb);
    }
}