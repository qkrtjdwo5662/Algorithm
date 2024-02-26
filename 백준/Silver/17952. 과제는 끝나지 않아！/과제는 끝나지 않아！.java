import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Task{
		int score;
		int remain;
		
		
		public Task(int score , int remain) {
			this.score = score;
			this.remain = remain;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Task> deque = new ArrayDeque<>();
		
		int total = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int opr = Integer.parseInt(st.nextToken());
			
			if(opr == 1) {
				int score = Integer.parseInt(st.nextToken());
				int remain = Integer.parseInt(st.nextToken());
				
				remain --;
				
				deque.addLast(new Task(score, remain));
			}else if(opr == 0) {
				if(deque.isEmpty()) {
					continue;
				}else {
					deque.peekLast().remain -- ;
				}
			}
			
			if(!deque.isEmpty() && deque.peekLast().remain == 0) {
				total += deque.pollLast().score;
			}
		}
		
		sb.append(total).append("\n");
		System.out.println(sb);
		
	}

}