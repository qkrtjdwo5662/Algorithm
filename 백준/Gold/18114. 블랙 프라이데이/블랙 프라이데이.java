import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int c;
    static int n;

    static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num == c){
                System.out.println(1);
                return;
            }
            arr[i] = num;
        }

        // n개의 배열에서 물품을 최대 3개 선택하여 c의 무게를 맞출 수 있는가
        // 2개와 3개 고려

        Arrays.sort(arr);
        answer = false;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = n - 1;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum > c){
                right --;
            }else if(sum < c){
                for(int num : set){
                    if(arr[left] + num == c || arr[right] + num == c){
                        System.out.println(1);
                        return;
                    }
                }

                set.add(sum);
                left ++;
            }else{
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
