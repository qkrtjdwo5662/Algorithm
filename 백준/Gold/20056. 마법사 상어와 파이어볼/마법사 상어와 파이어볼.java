import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fireball{
        int r;
        int c; // r, c 위치
        int m; // 질량
        int s; // 속도
        int d; // 방향

        public Fireball(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static int N;
    static int M;
    static int K;

    static int[] ry = {-1, -1, 0, 1, 1, 1,  0, -1};
    static int[] rx = {0, 1, 1,  1,  0, -1, -1, -1};
    static ArrayList<Fireball> fireballList = new ArrayList<>();
    static ArrayList<int[]> twoMoreList;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 맵 크기
        M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
        K = Integer.parseInt(st.nextToken()); // 이동 횟수

        map = new int[N + 1][N + 1]; // 개수 체크


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c] ++;
            fireballList.add(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) { // 1000
            // 이동 시작

            for (int j = 0; j < fireballList.size(); j++) {
                Fireball fireball = fireballList.get(j);

                int r = fireball.r;
                int c = fireball.c;
                int d = fireball.d;
                int s = fireball.s;

                int dy = (ry[d] * s) % N;
                int dx = (rx[d] * s) % N;

                r = (r + dy + N) % N;
                c = (c + dx + N) % N;


                if (r == 0) r = N;
                if (c == 0) c = N;


                map[fireball.r][fireball.c] --;

                fireball.r = r;
                fireball.c = c;

                map[r][c] ++;
            }
            checkAndGo();

        }

        int answer = 0;

        for (int i = 0; i < fireballList.size(); i++) {
            if(fireballList.get(i).m > 0){
                answer += fireballList.get(i).m;
            }

        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void checkAndGo(){
        // 같은 위치에 있는 파이어볼 체크

        twoMoreList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(map[i][j] >= 2) {
                    twoMoreList.add(new int[]{i, j});
                }

            }
        }

        for (int i = 0; i < twoMoreList.size(); i++) {
            int[] now = twoMoreList.get(i); // 이곳에는 두개 이상의 파이어볼이 존재한다.

            int count = map[now[0]][now[1]]; // 겹치는 파이어볼 개수
            int sumM = 0;
            int sumS = 0;

            List<Integer> checkFireballIndexList = new ArrayList<>();
            boolean flag = true;
            int tempD = -1;

            for (int j = 0; j < fireballList.size(); j++) {
                Fireball fireball = fireballList.get(j);

                if(fireball.r == now[0] && fireball.c == now[1]) {

                    checkFireballIndexList.add(j);
                    sumM += fireball.m;
                    sumS += fireball.s;

                }
            }

            for (int j = 0; j < checkFireballIndexList.size(); j++) {
                int index = checkFireballIndexList.get(j);

                if(tempD == -1){
                   tempD = fireballList.get(index).d;
                }else{
                    if((tempD % 2 == 0 && fireballList.get(index).d % 2 == 0)|| (tempD % 2 != 0 && fireballList.get(index).d % 2 != 0)){
                        continue;
                    }else flag = false;
                }
            }

            if(count >= 2 ){
                int m = sumM / 5;
                int s = sumS / count;

                boolean fflag = false;

                if(flag && m > 0){
                    fireballList.add(new Fireball(now[0], now[1], m, s, 0));
                    fireballList.add(new Fireball(now[0], now[1], m, s, 2));
                    fireballList.add(new Fireball(now[0], now[1], m, s, 4));
                    fireballList.add(new Fireball(now[0], now[1], m, s, 6));
                    fflag = true;

                }else if(!flag && m > 0){
                    fireballList.add(new Fireball(now[0], now[1], m, s, 1));
                    fireballList.add(new Fireball(now[0], now[1], m, s, 3));
                    fireballList.add(new Fireball(now[0], now[1], m, s, 5));
                    fireballList.add(new Fireball(now[0], now[1], m, s, 7));
                    fflag = true;

                }

                for (int j = checkFireballIndexList.size() - 1; j >= 0; j--) {
                    int index = checkFireballIndexList.get(j);
                    fireballList.remove(index);
                }

                if(fflag){
                    map[now[0]][now[1]] += 4;
                    map[now[0]][now[1]] -= count;
                }else map[now[0]][now[1]] -= count;

            }

        }
    }
}