import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        boolean[] exact = new boolean[n];

        int exactCount = 0;
        int index = 0; // 배열 인덱스
        int count = 1; // 몇 번째?
        sb.append("<");
        while(exactCount < n){

            if(count == k){
                if(!exact[index]){
                    exact[index] = true;
                    count = 1;
                    exactCount ++;
                    if(exactCount <= n - 1) sb.append(arr[index]).append(", ");
                    else sb.append(arr[index]).append(">");
                    index = (index + 1)%n;


                    continue;
                }
            }

            if(!exact[index]){
                count ++;
            }

            index = (index + 1)%n;
        }
        // 1 2 3 4 5 6 7

        // 1.. 2.. 3
        // 4.. 5.. 6
        // 7.. 1.. 2
        // 4.. 5 .. 7
        System.out.println(sb);
    }
}
