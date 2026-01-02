import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int num;
        int height;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> adjList[] = new ArrayList[n + 1]; // 연결리스트 정보
        List<Node> nodeList = new ArrayList<>();
        int[] info = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            int num = i;
            Node newNode = new Node();
            newNode.height = height;
            newNode.num = num;
            nodeList.add(newNode);

            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        nodeList.sort((o1, o2) -> {
            return o2.height - o1.height;
        });

        for (int i = 1; i <= n ; i++) {
            Node now = nodeList.get(i - 1);

            int num = now.num;
            int max = 0;
            for (int j = 0; j < adjList[num].size(); j++) {
                int to = adjList[num].get(j);

                max = Math.max(max, info[to]);
            }

            info[num] = max + 1;
        }

        for (int i = 1; i <= n ; i++) {
            System.out.println(info[i]);
        }

    }
}
