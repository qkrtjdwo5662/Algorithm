import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] board;
    static HashMap<Character, Character> map;
    static HashSet<Character> keySet;
    static int[] ry = {0, 0, 1, -1};
    static int[] rx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        map =new HashMap<>(); // 문 & 열쇠
        map.put('A', 'a');
        map.put('B', 'b');
        map.put('C', 'c');
        map.put('D', 'd');
        map.put('E', 'e');
        map.put('F', 'f');

        keySet = new HashSet<>();
        keySet.add('a');
        keySet.add('b');
        keySet.add('c');
        keySet.add('d');
        keySet.add('e');
        keySet.add('f');

        int startY = - 1;
        int startX = - 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);

                if(board[i][j] == '0'){
                    startY = i;
                    startX = j;
                }
            }
        }

        // 0 : 시작
        // 1 : 탈출구
        // a, b, c, d, e, f : 열쇠
        // A, B, C, D, E, F : 문
        // # : 벽
        // . : 빈칸

        int answer= bfs(startY, startX);
        sb.append(answer).append("\n");
        System.out.println(sb);

    }

    static int bfs(int y, int x){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][64];
        visited[y][x][0] = true;
        deque.addLast(new int[]{y, x, 0, 0});

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            int ny = now[0];
            int nx = now[1];
            int dist = now[2];
            int key = now[3];

//            System.out.println(ny + " " + nx + " " + dist + " " + key);
            if(board[ny][nx] == '1') return dist;

            for (int i = 0; i < 4; i++) {
                int r = ny + ry[i];
                int c = nx + rx[i];

                if(r < 0 || c < 0 || r>= n || c>= m) continue;

                char info = board[r][c];

                if(info == '#') continue; // 벽이요

                if(map.containsKey(info)){
                    // 문이요
                    if(((1 << map.get(info)-'a') & key) == (1 << map.get(info)-'a')){

                        if(!visited[r][c][key]){
                            visited[r][c][key] = true;
                            deque.addLast(new int[]{r, c, dist + 1, key});
                        }

                    }else{
                        continue;
                    }
                }else if(keySet.contains(info)){ // 요놈이 키면
                    int change = key | 1 << info -'a';  // key 보유처리
                    if(!visited[r][c][change]){
                        visited[r][c][change] = true;
                        deque.addLast(new int[]{r, c, dist + 1, change});
                    }
                }else {
                    if(!visited[r][c][key]){
                        visited[r][c][key] = true;
                        deque.addLast(new int[]{r, c, dist + 1, key});
                    }
                }

            }
        }

        return -1;
    }
}