import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0; // 배열 인덱스
        List<Integer> list = new ArrayList<>();
        while(index < n){
            if(list.size() == 0){
                list.add(arr[index]);
            }else{
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i) - 1 == arr[index]){
                        list.set(i, list.get(i) - 1);
                        flag = true;
                        break;
                    }
                }
                if(!flag) list.add(arr[index]);
            }

            index ++;
        }

        System.out.println(list.size());
    }
}
