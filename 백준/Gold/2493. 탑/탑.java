import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!deque.isEmpty() && deque.peekLast()[0] < num) {
				deque.pollLast();
			}

			if(deque.isEmpty()) sb.append(0).append(" ");
			else sb.append(deque.peekLast()[1]).append(" ");
			
			deque.addLast(new int[] {num, i+1});
		}
	
		
	
		System.out.println(sb);
		
	}
}