import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int b;
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String stoneArr = st.nextToken();

        int left = 0;
        int right = 1;

        int bCount = 0;
        int wCount = 0;

        if(stoneArr.charAt(0) == 'B'){
            bCount ++;
        }else wCount ++;

        int answer = 0;

        if(wCount >= w && bCount <= b){
            answer = Math.max(answer, right - left);
        }
        
        while(right < n && left <= right){

            if(bCount > b){
                if(stoneArr.charAt(left) == 'B'){
                    bCount --;
                }else wCount --;

                left ++;
            }else{
                if(stoneArr.charAt(right) == 'B'){
                    bCount ++;
                }else wCount ++;

                right ++;
            }

            if(wCount >= w && bCount <= b){
                answer = Math.max(answer, right - left);
            }

        }
        
        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}
