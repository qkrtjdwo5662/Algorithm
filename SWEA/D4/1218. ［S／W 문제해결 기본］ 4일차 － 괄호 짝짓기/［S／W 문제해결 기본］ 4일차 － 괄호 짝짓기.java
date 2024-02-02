import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');
		
		loop:
		for (int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(br.readLine());
			String s =br.readLine();
			ArrayDeque<Character> deque = new ArrayDeque<>();
			sb.append("#").append(i).append(" ");
			
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				
				if(map.containsKey(c)) { // 여는 괄호
					deque.addLast(c); // 넣고
				}else { // 닫는 괄호
					if(deque.isEmpty()) { //비어있으면 
						sb.append(0).append("\n");
						continue loop;
					}else {
						if(c != map.get(deque.pollLast())) {
							sb.append(0).append("\n");
							continue loop;
						}
					}
				}
			}
			if(!deque.isEmpty()) {
				sb.append(0).append("\n");
			}else {
				sb.append(1).append("\n");
			}
			
		}
		System.out.println(sb);
		
		

	}
}