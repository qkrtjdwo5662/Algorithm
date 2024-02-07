import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[101][101];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = y; j < y+10; j++) {
				for (int k = x; k < x + 10;  k++) {
					visited[j][k] = true;
				}
			}
		}
		int answer = 0;
		
		for (int i = 1; i <=100 ; i++) {
			for (int j = 1; j <= 100; j++) {
				if(visited[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}
}