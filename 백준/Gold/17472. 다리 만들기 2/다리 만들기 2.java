import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[][] groupBoard;
    static boolean[][] visited;
    static int[] ry = {0, 0, 1, -1};
    static int[] rx = {1, -1, 0, 0};
    static ArrayList<int[]>[] groupList;
    static int[] parents;
    static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        groupBoard = new int[n][m];

        // board 세팅
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }


        // groupBoard 세팅
        int groupNum = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j] != 0){
                    bfs(i, j, ++groupNum);
                }
            }
        }
        groupList = new ArrayList[groupNum + 1];
        parents = new int[groupNum + 1];
        for (int i = 1; i <= groupNum ; i++) {
            parents[i] = i;
            groupList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(groupBoard[i][j] != 0){
                    int group = groupBoard[i][j];
                    groupList[group].add(new int[]{i, j});
                }
            }
        }

        edgeList = new ArrayList<>();
        // edgeList 세팅
        for (int i = 1; i <= groupNum ; i++) {
            ArrayList<int[]> list = groupList[i];
            for (int j = 0; j < list.size(); j++) {
                int[] now = list.get(j);
                for (int k = 0; k < 4; k++) {
                    setBride(now[0], now[1], k, 0, i);
                }
            }
        }


        Collections.sort(edgeList, ((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        }));

//        printList(edgeList);
        int count = 0;
        int total = 0;
        boolean flag = false;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge now = edgeList.get(i);

            if(union(now.start, now.end)){
                count ++;
                total += now.weight;
            }

            if(count == groupNum-1) {
                flag = true;
                break;
            }
        }

        if(flag){
            sb.append(total).append("\n");
        }else sb.append(-1).append("\n");

        System.out.println(sb);


    }

    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x == y) return false;
        parents[x] = y;
        return true;
    }
    static int find(int a){
        if(parents[a] == a){
            return a;
        }

        return parents[a] = find(parents[a]);
    }
    static void setBride(int y, int x, int d, int len, int startGroup){
        int r = y + ry[d];
        int c = x + rx[d];

        if(r < 0 || c < 0 || r>= n || c>= m) return;

        if(groupBoard[r][c] != startGroup && groupBoard[r][c] != 0){
            if(len > 1){
                Edge edge = new Edge(startGroup, groupBoard[r][c], len);
                edgeList.add(edge);
            }


        }else if(groupBoard[r][c] == 0){
            setBride(r, c, d, len + 1, startGroup);
        }

    }

    static void bfs(int y, int x, int num){
        visited[y][x] = true;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{y, x});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            groupBoard[now[0]][now[1]] = num;
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c< 0 || r>= n || c>= m) continue;

                if(board[r][c] == 0) continue;

                if(visited[r][c]) continue;

                visited[r][c] = true;
                deque.addLast(new int[]{r, c});

            }
        }
    }

    static void print(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printList(ArrayList<Edge> edgeList){
        for (int i = 0; i <edgeList.size() ; i++) {
            Edge now = edgeList.get(i);
            System.out.println(now.start + " " + now.end + " " + now.weight);
        }
    }
}