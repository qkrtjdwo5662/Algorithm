import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Egg{
        int hp;
        int weight;

        public Egg(int hp, int weight){
            this.hp = hp;
            this.weight = weight;
        }
    }

    static Egg[] eggArr;
    static int answer;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        eggArr = new Egg[n];
        answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Egg egg = new Egg(hp, weight);

            eggArr[i] = egg;
        }

        backtrack(0);
        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static void backtrack(int depth){
        if(depth == n ){
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(eggArr[i].hp <= 0) count ++;
            }

            answer = Math.max(answer, count);
            return;
        }

        Egg now = eggArr[depth];

        if(now.hp <= 0) { // 손에 든거 깨졌으면 넘김
            backtrack(depth + 1);
        }else{
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if(i == depth) continue;

                Egg egg = eggArr[i];
                if (egg.hp > 0) {
                    flag = true;
                    int temp1 = now.hp;
                    int temp2 = egg.hp;

                    now.hp -= egg.weight;
                    egg.hp -= now.weight;

                    backtrack(depth + 1);

                    now.hp = temp1;
                    egg.hp = temp2;
                }
            }

            if(!flag) backtrack(depth + 1);
        }


    }
}