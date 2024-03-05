import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        int num = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(!map1.containsKey(s)){
                map1.put(s, num);
                map2.put(num, s);
                num ++;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(isNumber(s)){
                sb.append(map2.get(Integer.parseInt(s))).append("\n");
            }else{
                sb.append(map1.get(s)).append("\n");

            }
        }
        System.out.println(sb);
    }

    static boolean isNumber(String s){
        try{
            int num = Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}