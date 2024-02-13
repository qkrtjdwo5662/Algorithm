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
	
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(st.nextToken());
			arr[i] = height;
		}
		
		Arrays.sort(arr);
	
		for (int i = 0; i < arr.length; i++) {
			int height = arr[i];
			
			if(height <= l) {
				l++;
			}
		}
		
		sb.append(l).append("\n");
		System.out.println(sb);
	}
}