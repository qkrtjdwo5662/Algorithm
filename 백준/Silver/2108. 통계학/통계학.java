import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        double total = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            // 1 3 8 -2 2
            // -> -2 1 2 3 8

            // 1. 평균 // 순회해서 더하고 나누기 n
            // 2. 중앙값 arr[(n - 1)/2]
            // 3. 최빈값 // Map
            // 4. 범위 arr[n - 1] - arr[0];

            total += num;
        }
        Arrays.sort(arr);

        int max = 0;

        for (int key : map.keySet()) {
            if(map.get(key) > max){
                max = map.get(key);
            }
        }

        for (int key : map.keySet()) {
            if(map.get(key) == max){
                list.add(key);
            }
        }


        System.out.println((int)Math.round(total/n)); // 평균
        System.out.println(arr[(n - 1)/2]); // 중앙값
        Collections.sort(list);
        if(list.size() > 1){
            System.out.println(list.get(1)); // 최빈값의 두번째
        }else System.out.println(list.get(0));
        System.out.println(arr[n - 1] - arr[0]);
    }
}
