import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		visited = new boolean[n];
		Arrays.sort(arr);
		backtrack(0, "");
		System.out.println(sb);
	}
	
	static void backtrack(int depth, String now) {
		if(depth == m) {
			System.out.println(now);
			return;
		}
		
		
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(depth + 1, now+arr[i] + " ");
				visited[i] = false;
			}
		}
		
	}
}