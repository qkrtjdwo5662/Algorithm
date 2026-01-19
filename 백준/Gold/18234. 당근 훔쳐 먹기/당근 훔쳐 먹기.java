import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Carrot{
        int w; // 맛
        int p; // 영양제

        public Carrot(int w, int p){
            this.w = w;
            this.p = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<Carrot> carrots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Carrot carrot = new Carrot(w, p);
            carrots.add(carrot);
        }

        carrots.sort((o1, o2) -> {
            return o1.p - o2.p;
        });

        long answer = 0;

        for (int i = 0; i < n; i++) {
            Carrot now = carrots.get(i);
            answer += (long) (t - n + i) * now.p + now.w;
        }

        System.out.println(answer);
    }
}
