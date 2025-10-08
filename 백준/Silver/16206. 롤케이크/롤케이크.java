import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        // 나누어 떨어지는 그룹과 떨어지지 않는 그룹으로 나눈다.
        List<Integer> divisible = new ArrayList<>();
        List<Integer> nonDivisible = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i] == 10) count ++;
            else if(arr[i] > 10 && arr[i] % 10 != 0) nonDivisible.add(arr[i]);
            else if(arr[i] > 10 && arr[i] % 10 == 0) divisible.add(arr[i]);
        }

        Collections.sort(divisible);
        Collections.sort(nonDivisible);
        
        for (int num : divisible) {
            if(m == 0) break;

            int share = (num / 10) - 1;
            if(share <= m){
                count += num / 10;
                m -= share;
            }else{
                count += m;
                m = 0;
            }
        }

        for (int num : nonDivisible) {
            if(m == 0) break;

            int share = num / 10;
            if(share <= m){
                count += num / 10;
                m -= share;
            }else{
                count += m;
                m = 0;
            }
        }

        System.out.println(count);
    }
}
