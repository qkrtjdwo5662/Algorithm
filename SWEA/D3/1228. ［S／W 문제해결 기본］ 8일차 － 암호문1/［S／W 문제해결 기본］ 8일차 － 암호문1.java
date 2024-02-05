import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			LinkedList<Integer> linkedList = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				linkedList.add(num);
			}
			
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				String s = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				for (int k = 0; k < y; k++) {
					int num = Integer.parseInt(st.nextToken());
					linkedList.add(x+k, num);
				}
			
			}
			sb.append("#").append(i).append(" ");
			for (int j = 0; j < 10; j++) {
				sb.append(linkedList.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}