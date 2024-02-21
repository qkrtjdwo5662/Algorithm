import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n + 1];
			
			for (int j = 0; j < parents.length; j++) {
				parents[j] = j;
			}
			
			sb.append("#").append(i).append(" ");
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				
				int opr = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(opr == 0) {
					union(a, b);
				}else if(opr == 1) {
					if(find(a) == find(b)) {
						sb.append(1);
					}else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		parents[x] = y;
	}
	
	static int find(int a) {
		if(parents[a] == a) return parents[a];
		
		return parents[a] = find(parents[a]);
	}
}