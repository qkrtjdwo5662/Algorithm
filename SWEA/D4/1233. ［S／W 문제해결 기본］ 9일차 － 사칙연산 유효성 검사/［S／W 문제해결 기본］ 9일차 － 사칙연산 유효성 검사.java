import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		set.add("*");
		set.add("-");
		set.add("/");
		set.add("+");
		
		int tc = 10;
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			for (int j = 1; j <= n; j++) {
				st = new StringTokenizer(br.readLine());
				if(j <= n/2) {
					
					int index = Integer.parseInt(st.nextToken());
					String opr = st.nextToken();

					if(!set.contains(opr)) {
						flag = true;
					}
					
					int child1 = Integer.parseInt(st.nextToken());
					if(n%2 == 0 && j != n/2) {
						int child2 = Integer.parseInt(st.nextToken());
					}			
					
				}else {
					int index = Integer.parseInt(st.nextToken());
					String value = st.nextToken();
					if(set.contains(value)) {
						flag = true;
					}
				}		
			}
			if(flag) sb.append("#").append(i).append(" ").append("0").append("\n");
			else sb.append("#").append(i).append(" ").append("1").append("\n");
		}
		System.out.println(sb);
		
	}
}