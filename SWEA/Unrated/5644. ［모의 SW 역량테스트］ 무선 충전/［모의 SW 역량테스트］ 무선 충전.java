import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class User{
        int y;
        int x;

        public User(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class BC{
        int y;
        int x;
        int c;
        int p;
        public BC(int y, int x, int c, int p){
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }
    }

    static int m;
    static int[][] test;
    static ArrayList<Integer>[][] board;
    static int[] ry = {0, -1, 0, 1, 0};
    static int[] rx = {0, 0, 1, 0, -1};
    static int[] countArr;
    static User A;
    static User B;
    static BC[] bcs;
    static int answer;
    static int tempA;
    static int tempB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            board = new ArrayList[11][11];
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10 ; k++) {
                    board[j][k] = new ArrayList<>();
                }
            }

            test = new int[11][11];
            countArr = new int[a + 1];
            int[][] moveInfo = new int[2][m]; // A, B 이동 정보

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    moveInfo[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            A = new User(1, 1);
            B = new User(10, 10);

            bcs = new BC[a + 1];
            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken()); // 충전 범위
                int p = Integer.parseInt(st.nextToken()); // 충전 량

                BC bc = new BC(y,x, c, p);
                bcs[j + 1] = bc;
                indicateBC(bc, j+1);
            }

            answer = 0;
            tempA = 0;
            tempB = 0;
            move(0, 0, 0);
            for (int j = 0; j < m; j++) {
                // 하나씩 움직이는거 꺼내서
                int d1 = moveInfo[0][j];
                int d2 = moveInfo[1][j];
                move(j+1, d1, d2);
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);

    }
    static void sum(int y1, int x1, int y2, int x2){
        ArrayList<Integer> listA = board[y1][x1];
        ArrayList<Integer> listB = board[y2][x2];

        // 동시 비교 후 처리 ㄱㄱ
        int maxA = 0;
        int maxB = 0;
        int indexA = 0;
        int indexB = 0;

        if(listA.size() > 0 && listB.size() == 0){
            for (int i = 0; i < listA.size(); i++) {
                maxA = Math.max(bcs[listA.get(i)].p, maxA);
            }
            answer += maxA;
        }else if(listA.size() == 0 && listB.size() > 0 ){
            for (int i = 0; i < listB.size(); i++) {
                maxB = Math.max(bcs[listB.get(i)].p, maxB);
            }
            answer += maxB;
        }else if(listA.size() > 0 && listB.size() > 0){
            for (int i = 0; i < listA.size(); i++) {
                if(maxA < bcs[listA.get(i)].p){
                    maxA = bcs[listA.get(i)].p;
                    indexA = listA.get(i);
                }
                for (int j = 0; j < listB.size() ; j++) {
                    if(maxB < bcs[listB.get(j)].p){
                        maxB= bcs[listB.get(j)].p;
                        indexB = listB.get(j);
                    }
                }
            }

            if(maxA == maxB){
                if(indexA == indexB){
                    int tempA = 0;
                    for (int i = 0; i < listA.size(); i++) {
                        if(bcs[listA.get(i)].p != maxA) {
                            tempA = Math.max(bcs[listA.get(i)].p, tempA);
                        }
                    }

                    int tempB = 0;
                    for (int i = 0; i < listB.size(); i++) {
                        if(bcs[listB.get(i)].p != maxB) {
                            tempB = Math.max(bcs[listB.get(i)].p, tempB);
                        }
                    }

                    answer += Math.max(tempA + maxB, tempB + maxA);
                }else answer += maxA + maxB;

            }else{
                answer += maxA + maxB;
            }
        }
    }

    static void move(int index,int d1, int d2){
        if(index == m+1){
            return;
        }else{
            if(index ==0){
                sum(A.y, A.x, B.y, B.x);
            }else{
                A.y += ry[d1];
                A.x += rx[d1];

                B.y += ry[d2];
                B.x += rx[d2];

                sum(A.y, A.x, B.y, B.x);
            }
        }



    }
    static void indicateBC(BC bc, int index){
        int y = bc.y;
        int x = bc.x;
        // 중심 좌표

        int c = bc.c;
        for (int i = 1; i <= c ; i++) {
            y += ry[1];
            for (int j = x-c+i; j <= x+c-i; j++) {
                if(!isBound(y, j)) continue;
                board[y][j].add(index);
            }
        }

        y = bc.y;
        for (int i = x-c; i <= x + c; i++) {
            if(!isBound(y, i)) continue;
            board[y][i].add(index);
        }

        for (int i = 1; i <= c; i++) {
            y += ry[3];
            for (int j = x-c+i; j <= x+c-i; j++) {
                if(!isBound(y, j)) continue;
                board[y][j].add(index);
            }
        }



    }
    static boolean isBound(int y, int x){
        if(y < 1 || x < 1 || y>10 || x > 10) return false;

        return true;
    }
}