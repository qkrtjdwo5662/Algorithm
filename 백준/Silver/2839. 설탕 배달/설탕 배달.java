import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        int[] count = new int[6];	

        count[5] = n/5;
        

        while(count[5] >= 0){
            int target = n;
            target = target - count[5]*5;
            
            if(target % 3 ==0){
                count[3] = target/3;
                answer = Math.min(answer, count[5] + count[3]);
            }
            count[5] --;
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else System.out.println(answer);

    }
}