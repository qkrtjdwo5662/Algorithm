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
		
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[i][0] = start;
			arr[i][1] = end;
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				if(o1[0] == o2[0]) {
					return Integer.compare(o1[1] - o1[0], o2[1] - o2[0]);
				}else return Integer.compare(o1[0], o2[0]);
			}else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int count = 0;
		int end = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int nowStart = arr[i][0];
			int nowEnd = arr[i][1];
			
			if(nowStart >= end) {
				end = nowEnd;
				count++;
			}
			
		}
		System.out.println(count);
		
	}
}