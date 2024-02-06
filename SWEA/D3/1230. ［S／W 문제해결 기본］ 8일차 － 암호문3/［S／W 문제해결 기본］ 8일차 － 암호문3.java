import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10 ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 원본 암호문 개수

            ArrayList<Integer> list = new ArrayList<>(); 
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 명령어의 개수

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String opr = st.nextToken(); // 명령어

                if(opr.equals("I")){
                    // x, y, s
                    // x번째 암호문 뒤에 y개의 암호문 삽입
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int k = 0; k < y; k++) {
                        int s = Integer.parseInt(st.nextToken());
                        list.add(k + x, s);
                    }
                } else if (opr.equals("D")) {
                    // x, y
                    // x번째 암호문 뒤에 y개의 암호문 삭제

                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int k = 0; k < y; k++) {
                    	list.remove(k + x);
                    }
                } else if (opr.equals("A")) {
                    // y, s
                    // 맨뒤 y개의 암호문 삽입
                    int y = Integer.parseInt(st.nextToken());
                    for (int k = 0; k < y; k++) {
                        int s = Integer.parseInt(st.nextToken());
                        list.add(s);
                    }

                }
            }

            sb.append("#").append(i).append(" ");
            for (int j = 0; j < 10; j++) {
                sb.append(list.get(j)).append(" ");
            }
            sb.append("\n");


        }
        System.out.println(sb);
    }
}