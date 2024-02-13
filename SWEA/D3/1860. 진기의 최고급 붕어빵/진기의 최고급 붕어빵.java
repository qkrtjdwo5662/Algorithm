import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		loop:
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // 자격얻은 사람
			int m = Integer.parseInt(st.nextToken()); 
			int k = Integer.parseInt(st.nextToken());
			// m초에 k개의 붕어빵
			
			int[] person = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				person[j] = num;
			}
			
			Arrays.sort(person);
			int index = 0;
			int time = 0;
			
			int now = 0; // 현재 붕어빵 개수
			
			while(index < n) {
				if(time != 0 && time % m == 0) {
					now += k;
				}
				
				if(time > person[index]) {
					sb.append("#").append(i).append(" ").append("Impossible").append("\n");
					continue loop;
				}
				
				while(time == person[index]) {
					if(now > 0) {
						now --;
						index ++;
					}else {
						sb.append("#").append(i).append(" ").append("Impossible").append("\n");
						continue loop;
					}
					
					if(n == index) break;
				}
				
				time ++;
			}
			sb.append("#").append(i).append(" ").append("Possible").append("\n");
		}
		System.out.println(sb);
		
	}
}