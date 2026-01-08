import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = st.nextToken();

        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                zeroCount ++;
            }else oneCount ++;
        }

        zeroCount /= 2;
        oneCount /= 2;

        // 홀수번째 문자는 1, 짝수번째 문자는 0
        
        for (int i = 0; i < zeroCount; i++) {
            sb.append(0);
        }

        for (int i = 0; i < oneCount; i++) {
            sb.append(1);
        }
        
//        int count = 0;
//        while (zeroCount > 0 && oneCount > 0){
//            if(count%2 != 0){
//                sb.append(0);
//                zeroCount --;
//            }else sb.append(1);
//        }
        System.out.println(sb);
        
        
        
        
    }
}
