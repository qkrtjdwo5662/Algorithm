import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] board;
    static boolean[] visited;
    static int answer;
    static int totalA;
    static int totalB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            board = new int[n][n];
            visited = new boolean[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }
            answer = Integer.MAX_VALUE;
            totalA = 0;
            totalB = 0;
            divideIngredients(0, new ArrayList<>(), 0);

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);

    }

    // n/2 조합
    static void divideIngredients(int depth, ArrayList<Integer> list, int index){
        if(depth == n/2){
            ArrayList<Integer> listB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    listB.add(i);
                }
            }
            boolean[] used = new boolean[n/2];
            pickTwo(0, list, listB, new ArrayList<>(), new ArrayList<>(), used, 0);
            int abs = Math.abs(totalA - totalB);
            answer = Math.min(abs, answer);
            totalA = 0;
            totalB = 0;
            return;
        }

        for (int i = index; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                divideIngredients(depth+1, list, i);
                list.remove(list.size() -1);
                visited[i] = false;
            }
        }
    }

    static void pickTwo(int depth, ArrayList<Integer> listA, ArrayList<Integer> listB, ArrayList<Integer> listAA, ArrayList<Integer> listBB, boolean[] used, int index){
        if(depth == 2){
            int A1 = board[listAA.get(0)][listAA.get(1)];
            int A2 = board[listAA.get(1)][listAA.get(0)];

            int B1 = board[listBB.get(0)][listBB.get(1)];
            int B2 = board[listBB.get(1)][listBB.get(0)];

            int A = A1 + A2;
            int B = B1 + B2;

            totalA +=A;
            totalB +=B;

            return;
        }

        for (int i = index; i < n/2; i++) {
            if(!used[i]){
                used[i] = true;
                listAA.add(listA.get(i));
                listBB.add(listB.get(i));
                pickTwo(depth+1, listA, listB, listAA, listBB, used, i);
                listAA.remove(listAA.size() - 1);
                listBB.remove(listBB.size() - 1);
                used[i] = false;
            }
        }
    }
}