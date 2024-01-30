import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			String bits = br.readLine();
			char prev = '0';
			int answer = 0;
			for (int j = 0; j < bits.length(); j++) {
				if(prev != bits.charAt(j)) {
					answer ++;
					prev = bits.charAt(j);
				}
			}
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}