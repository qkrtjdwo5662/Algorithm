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
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num;
			}
			
			int answer = 0;
			Arrays.sort(arr);
			
			int left = 0;
			int right = n-1;
			
			while(left < right) {
				int total = 0;
				total = arr[left] + arr[right];
				
				if(total <= m) {
					answer = Math.max(answer, total);
					left++;
				}else {
					right --;
				}
				
				
			}
			
			if(answer == 0) sb.append("#").append(i).append(" ").append(-1).append("\n");
			else sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}