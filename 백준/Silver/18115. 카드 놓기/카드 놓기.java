import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayDeque<Integer> result;
    static ArrayDeque<Integer> first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 카드 놓기
        // 제일 위의 카드 1장 바닥에 내려놓음
        // 위에서 두번째 카드 바닥에 내려놓음 (단, 카드가 2장이상 일때)
        // 제일 밑에 있는 카드를 바닥에 내려놓은 (단, 카드가 2장이상 일때)

        // 결과적으로는 5, 4, 3, 2, 1
        result = new ArrayDeque<>();
        first = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n ; i++) {
            result.addFirst(i);
        }
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for (int i = n - 1; i >= 0 ; i--) {
            skill(arr[i]);
        }
        // 5 4 3 2 1
//        System.out.println(first);

        while(!first.isEmpty()){
            sb.append(first.pollLast()).append(" ");
        }
        System.out.println(sb);
    }

    static void skill(int num){
        if(result.isEmpty()) return;

        int poll = result.pollLast();
        if(num == 1){
            // 맨앞을 맨뒤로
            first.addLast(poll);
        }else if(first.size() >= 1 && num == 2){
            // 맨앞을 뒤에서 두번째로
            int firstPoll = first.pollLast();
            first.addLast(poll);
            first.addLast(firstPoll);
        }else if(first.size() >= 1 && num == 3){
            // 맨앞을 맨 앞으로
            first.addFirst(poll);
        }
    }
}
