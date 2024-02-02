import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			st =new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
			}
			
			int index = 1;
			
			while(true) {
				if(index == 6) index = 1; // reset

				int poll = deque.pollFirst();
				
				poll -= index;
				
				if(poll > 0) {
					deque.addLast(poll);
				}else {
					deque.addLast(0);
					break;
				}
				index ++;
			}
			
			sb.append("#").append(i).append(" ");
			while(!deque.isEmpty()) {
				int poll = deque.pollFirst();
				
				sb.append(poll).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}