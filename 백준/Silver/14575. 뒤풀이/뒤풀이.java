import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Person{
        int l;
        int r;

        public Person(int l, int r){
            this.l = l;
            this.r = r;
        }
    }

    static List<Person> personList;
    public static void main(String[] args) throws IOException {
        // 마시면 기분좋고 힘듬

        // l미만의 술을 마시면 술이 부족해서 기분 안좋음
        // R을 초과하면 천국으로 가버림

        // 모든 사람이 l이상 r이하의 술을 받고,
        // 총량은 T
        // S를 초과하지는 않게

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        personList = new ArrayList<>();
        int lTotal = 0;
        int rTotal = 0;
        int rMin = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            Person person = new Person(l, r);
            lTotal += l;
            rTotal += r;
            personList.add(person);
        }

        int left = 1;
        int right = 1_000_000_000;
        // mid가 S가 될 수 있는가?

        if(lTotal > t || rTotal < t){
            System.out.println(-1);
            return;
        }

        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            int total = 0;

            boolean flag = true;
            for (int i = 0; i < personList.size(); i++) {
                Person now = personList.get(i);

                if(now.l > mid) {
                    flag = false;
                    break;
                }
                total += Math.min(now.r, mid);
            }
            if(!flag){
                left = mid + 1;
                continue;
            }

            if(lTotal <= t && t <= total){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
