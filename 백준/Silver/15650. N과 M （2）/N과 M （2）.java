import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[n +1];
		backtrack(0, visited, 1, "");
	}
	
	public static void backtrack(int depth, boolean[] visited, int index, String s) {
		if(depth == m) {
			System.out.println(s);
			return;
		}
		
		for (int i = index; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(depth + 1, visited, i, s + i +" ");
				visited[i] = false;
			}
		}
	}
	
}