import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] mapInfo;
    static char[][] map;
    static List<int[]> list;
    static int h;
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        mapInfo = new int[h][w];

        list = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < w; j++) {
                map[i][j] = s.charAt(j);
                if(s.charAt(j) == '.'){
                    mapInfo[i][j] = -1;
                }else if(s.charAt(j) == 'c') list.add(new int[]{i, j});
            }
        }

        go();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(mapInfo[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void go(){
        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            while(true){
                int c = now[1] + 1;
                int r = now[0];

                if(c >= w) break;

                if(mapInfo[r][c] == -1) mapInfo[r][c] = mapInfo[now[0]][now[1]] + 1;



                now[1] = c;
                now[0] = r;
            }
        }
    }
}