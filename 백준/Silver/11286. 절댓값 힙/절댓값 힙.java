import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {
			int absX = Math.abs(o1);
			int absY = Math.abs(o2);
			
			if(absX == absY) {
				if(o1 <= o2) return -1;
				else return 1;
			}else if(absX < absY) return -1;
			else return 1;
		});
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(!minHeap.isEmpty()) {
					sb.append(minHeap.poll()).append("\n");
				}else sb.append(0).append("\n");
				
			}else {
				minHeap.add(num);
			}
		}
		
		System.out.println(sb);
		
	}
}