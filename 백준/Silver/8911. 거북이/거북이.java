import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ry = {1, 0, -1, 0};
    static int[] rx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            int maxY = 0;
            int minY = 0;

            int maxX = 0;
            int minX = 0;

            int ny = 0;
            int nx = 0;
            int d = 0;
            //F: 한 눈금 앞으로
            //B: 한 눈금 뒤로
            //L: 왼쪽으로 90도 회전
            //R: 오른쪽으로 90도 회전
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'F'){
                    ny += ry[d];
                    nx += rx[d];

                }else if(s.charAt(i) == 'B'){
                    ny -= ry[d];
                    nx -= rx[d];

                }else if(s.charAt(i) == 'L'){
                    d -= 1;
                    if(d < 0) d = 3;
                }else if(s.charAt(i) == 'R'){
                    d += 1;
                    d %= 4;
                }

                maxY = Math.max(maxY, ny);
                minY = Math.min(minY, ny);
                maxX = Math.max(maxX, nx);
                minX = Math.min(minX, nx);

//                System.out.println(ny + " " + nx);
            }
            sb.append(Math.abs(maxY - minY) * Math.abs(maxX - minX)).append("\n");
        }
        System.out.println(sb);
    }
}
