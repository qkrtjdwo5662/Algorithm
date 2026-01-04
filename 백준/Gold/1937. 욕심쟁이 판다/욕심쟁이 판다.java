import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    static class Node{
        int y;
        int x;
        int h;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        List<Node> nodeList = new ArrayList<>();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                Node newNode = new Node();
                newNode.y = i;
                newNode.x = j;
                newNode.h = num;

                nodeList.add(newNode);
            }
        }

        nodeList.sort((o1, o2) -> {
           return Integer.compare(o2.h, o1.h);
        });

        int answer = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);

            int ny = node.y;
            int nx = node.x;

            int max = 0;
            for (int j = 0; j < 4; j++) {
                int y = ny + ry[j];
                int x = nx + rx[j];

                if(y < 0 || x < 0 || y >= n || x >= n) continue;

                if(arr[y][x] <= arr[ny][nx]) continue;

                max = Math.max(max, dp[y][x]);
            }
            dp[ny][nx] = max + 1;
            answer = Math.max(answer, dp[ny][nx]);
        }
        System.out.println(answer);
    }
}
