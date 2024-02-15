import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static int r;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        divide(0, 0, size);

    }

    public static void divide(int x, int y,int size){
        if(size == 2){
            for (int i = y ; i < y+size; i++) {
                for (int j = x; j <x+size ; j++) {
                    if(r==i && c==j){
                        System.out.println(count);
                    }
                    count++;
                }
            }
        }

        if(x<=c && c<x+size/2 && y<=r && r<y+size/2){
            count = count;
            divide(x, y, size/2);
        }else if(x+size/2<=c && c<x+size && y<=r && r<y+size/2){
            count = count+size/2 * size/2;
            divide(x+size/2, y, size/2);
        }else if(x<=c && c<x+size/2 && y+size/2<=r && r<y+size){
            count = count+size/2 * size/2 * 2;
            divide(x, y+size/2, size/2);
        }else if(x+size/2<=c && c<x+size  && y+size/2<=r && r<y+size){
            count = count+size/2 * size/2 * 3;
            divide(x+size/2, y+size/2, size/2);
        }


    }
}
