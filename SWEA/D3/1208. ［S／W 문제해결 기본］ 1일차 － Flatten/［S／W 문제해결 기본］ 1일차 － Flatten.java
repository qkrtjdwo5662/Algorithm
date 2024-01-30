import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 100; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num;
			}
			
			for (int j = 0; j < count; j++) {
				Arrays.sort(arr);
				arr[99] --;
				arr[0] ++;
			}
			Arrays.sort(arr);
			int answer = arr[99] - arr[0];
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}