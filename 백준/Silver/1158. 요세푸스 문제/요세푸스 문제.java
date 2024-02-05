import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// 왼 -> 오 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			deque.addLast(i);
		}
		
		sb.append("<");
		int index = 1;
		
		while(deque.size() > 1) {
			if(index % k == 0) {
				sb.append(deque.pollFirst());
				sb.append(", ");
			}else deque.addLast(deque.pollFirst());
			index ++;
		}
		
		sb.append(deque.pollFirst());
		sb.append(">");
		System.out.println(sb);
		
		
	}
}