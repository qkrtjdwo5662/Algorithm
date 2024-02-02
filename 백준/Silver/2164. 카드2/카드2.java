import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			deque.addLast(i);
		}
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		
		while(true) {
			deque.pollFirst();
			
			if(deque.size() == 1) break;
			else deque.addLast(deque.pollFirst());
		}
		
		System.out.println(deque.pollFirst());
	}
}