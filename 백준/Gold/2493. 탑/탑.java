import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.peekLast()[1] < num) {
				deque.pollLast();
			}
			if(deque.size() == 0 ) {
				sb.append(0).append(" ");
			}else {
				sb.append(deque.peekLast()[0]).append(" ");
			}
			
			
			deque.addLast(new int[] {i + 1, num});
		}
		System.out.println(sb);
		
		
	}
}