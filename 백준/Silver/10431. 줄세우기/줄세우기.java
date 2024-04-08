import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[20];
			int[] sortArr = new int[20];
			for (int j = 0; j < 20; j++) {
				int height = Integer.parseInt(st.nextToken());
				arr[j] = height;
				sortArr[j] = height;
			}
			
			Arrays.sort(sortArr);
			int answer =0;
			for (int j = 0; j < 20; j++) {
				for (int k = j; k >= 0 ; k--) {
					if(arr[j] < arr[k]) {
						answer += 1;
					}
				}
			}
			
			sb.append(num).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
}