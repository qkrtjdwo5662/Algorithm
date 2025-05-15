import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] adjList;
    static int[] parent;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 2];
        adjList = new List[n + 2];
        visited = new boolean[n + 2];

        for (int i = 1; i <= n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n/2 ; i++) {
            adjList[i].add(i*2);
            adjList[i].add(i*2 + 1);

            parent[i * 2] = i;
            parent[i * 2 + 1] = i;
        }

//        System.out.println(Arrays.toString(parent));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            // 이 num을 오리가 가질 수 있는가?

            // 부모를 역추적해서 넣기
            int depth = 0;

            while(Math.pow(2, depth) < num){
                depth ++;
            }

            arr = new int[depth];
            int index = depth - 1;
            arr[index--] = num;
            int temp = num;
            while(index >= 0){
                arr[index] = parent[temp];
                index--;
                temp /= 2;
            }

//            System.out.println(Arrays.toString(arr) + " " + num);
            dfs(0, num);
        }
    }

    static void dfs(int depth, int target){
        if(depth == arr.length) return;

        if(visited[arr[depth]]){
            System.out.println(arr[depth]);
            return;
        }

        if(arr[depth] == target){
            visited[arr[depth]] = true;
            System.out.println(0);
            return;
        }else{
            dfs(depth + 1, target);
        }
    }

}
