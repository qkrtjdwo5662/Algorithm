import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 987654321;
	static int n;
	static int[][] dist;
	static StringBuilder sb;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		loop:
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			
			dist = new int[n][n];

			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					if(i == j) {
						continue;
					}
					
					if(num == 0) {
						dist[i][j] = INF;
					}else if(num == 1) {
						dist[i][j] = 1;
					}
					
					
				}
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			
			int min = 987654321;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += dist[i][j];
				}
				min = Math.min(min, sum);
			}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
			}
		}
	}
	
}