import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;


        int count_five = 0;
        count_five = n/5;
        int count_three = 0;

        while(count_five >= 0){
            int target = n;
            target = target - count_five*5;
            if(target%3 ==0){
                count_three = target/3;
                answer = Math.min(answer, count_five + count_three);
            }

            count_five--;
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else System.out.println(answer);

    }
}