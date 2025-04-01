import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        // queue addLast - pollFirst

        for (int i = 1; i <= n ; i++) {
            arrayDeque.addLast(i);
        }

        sb.append("<");

        int count = 0;
        while(arrayDeque.size() > 1){
            int now = arrayDeque.pollFirst();
            count++;

            if(count == k){
                sb.append(now).append(", ");
                count = 0;
            }else{
                arrayDeque.addLast(now);
            }
        }
        sb.append(arrayDeque.pollFirst());
        sb.append(">");
        System.out.print(sb);

    }
}
