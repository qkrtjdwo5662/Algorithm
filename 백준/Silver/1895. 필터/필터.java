import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        int[][] filter = new int[n - 2][m - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                int startY = i;
                int startX = j;

                List<Integer> list = new ArrayList<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        list.add(map[k][l]);
                    }
                }

                Collections.sort(list);
                filter[i][j] = list.get(4);
            }
        }

        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if(filter[i][j] >= t ) answer ++;
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
}