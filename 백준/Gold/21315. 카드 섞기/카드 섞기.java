import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // 원래의 카드를 뒤집어서 arr가 될 수 있게

        int maxK = -1;

        while(Math.pow(2, maxK + 1) <= n){
            maxK++;
        }

        loop:
        for (int i = 1; i <= maxK ; i++) {
            for (int j = 1; j <= maxK ; j++) {
                // i, j 조합
                int[] card = new int[n];

                for (int k = 1; k <= n ; k++) {
                    card[k - 1] = k;
                }

                shuffle(i, 0, card, new ArrayList<>());
                shuffle(j, 0, card, new ArrayList<>());

                boolean flag = true;
                for (int k = 0; k < n ; k++) {
                    if(card[k] != arr[k]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    sb.append(i).append(" ").append(j);
                    break loop;
                }
            }
        }
        System.out.println(sb);

    }
    static void shuffle(int k, int depth, int[] card, List<Integer> list){
        if(depth == k + 1) return;

        if(depth == 0){
            int[] temp = new int[card.length];
            int index = 0;
            // 5 - 4 = 1
            // 1 2 3 4
            for (int i = n - (int)Math.pow(2, k); i < n; i++) {
                temp[index ++] = card[i];
                list.add(card[i]);
            }

            for (int i = 0; i < n - (int) Math.pow(2,k); i++) {
                temp[index ++] = card[i];
            }

            for (int i = 0; i < n; i++) {
                card[i] = temp[i];
            }

            shuffle(k, depth + 1, card, list);
        }else{
            int[] temp = new int[card.length];
            List<Integer> newList = new ArrayList<>();
            int index = 0;
            // 5 - 2 = 3
            // 3, 4
            for (int i = list.size() - (int)Math.pow(2, k - depth); i < list.size() ; i++) {
                temp[index ++] = list.get(i);
                newList.add(list.get(i));
            }

            for (int i = 0; i < list.size() - (int) Math.pow(2, k - depth); i++) {
                temp[index ++] = list.get(i);
            }

            for (int i = index; i < n; i++) {
                temp[i] = card[i];
            }

            for (int i = 0; i < n; i++) {
                card[i] = temp[i];
            }


            shuffle(k, depth + 1, card, newList);
        }

        // 첫 번째 단계는 카드 더미 중 밑에서 2K개의 카드를 더미의 맨 위로 올린다.
        // i(2 ≤ i ≤ K + 1)번째 단계는 직전에 맨 위로 올린 카드 중 밑에서 2K - i + 1개의 카드를 더미의 맨 위로 올린다.
        //예를 들어, 카드의 개수가 5개 일 때 초기 상태에서 (2, 2) - 섞기를 하는 과정은 다음과 같다.(괄호 내에서 왼쪽에 있을수록 위에 있는 카드이다.)
    }


}
