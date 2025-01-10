import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] countArr = new int[101]; // 학생들의 추천 수 count

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(!list.contains(num)){
                list.add(num);
            }

            countArr[num] ++;

            if(list.size() > n){
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < list.size() - 1; j++) {
                    min = Math.min(min, countArr[list.get(j)]); // count 최솟값 도출
                }

                int index = 0;
                for (int j = 0; j < list.size() - 1; j++) {
                    if(min == countArr[list.get(j)]){
                        index = j;
                        break;
                    }
                }
                countArr[list.get(index)] = 0;
                list.remove(index);
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
