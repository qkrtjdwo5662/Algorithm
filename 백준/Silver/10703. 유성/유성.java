import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int S;
    static int[][] init;
    static List<int[]> star;
    static List<int[]> starBottom;
    static List<int[]> land;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        init = new int[R][S];

        star = new ArrayList<>();
        starBottom = new ArrayList<>();
        land = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < S; j++) {
                char c = s.charAt(j);

                if(c == 'X'){
                    star.add(new int[]{i, j});
                    init[i][j] = 2;
                }else if(c == '#'){
                    land.add(new int[]{i, j});
                    init[i][j] = 1;
                }

            }
        }

        loop:
        for (int i = 0; i < S; i++) {
            for (int j = R - 1; j >= 0; j--) {
                if(init[j][i] == 2) {
                    starBottom.add(new int[]{j, i});
                    continue loop;
                }
            }
        }

        int dist = maxDistance();

        int[][] answer = new int[R][S];

        for (int i = 0; i < star.size(); i++) {
            int[] now = star.get(i);
            answer[now[0] + dist][now[1]] = 2;
        }

        for (int i = 0; i < land.size(); i++) {
            int[] now = land.get(i);
            answer[now[0]][now[1]] = 1;
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if(answer[i][j] == 0) sb.append('.');
                else if(answer[i][j] == 1) sb.append('#');
                else sb.append('X');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int maxDistance(){
        int max = R;

        for (int i = 0; i < starBottom.size(); i++) {
            int[] now = starBottom.get(i);

            int r = now[0];
            int c = now[1];

            int dist = 0;
            while(true){
                r += 1;
                if(init[r][c] == 1 || r >= R) break;

                dist ++;
            }

            max = Math.min(dist, max);
        }
        return max;
    }
    static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void printList(List<int[]> list){
        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);

            System.out.println(now[0] + " " + now[1]);
        }
    }
}