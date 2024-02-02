import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String opr = br.readLine();
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		ArrayDeque<Double> deque = new ArrayDeque<>();
		HashSet<Character> set = new HashSet<>(); 
		set.add('*');
		set.add('+');
		set.add('/');
		set.add('-');
		
		for (int i = 0; i < opr.length(); i++) {
			if(!set.contains(opr.charAt(i))) {
				deque.addLast((double) (arr[opr.charAt(i) - 'A']));
			}else {
				double b = deque.pollLast();
				double a = deque.pollLast();
				
				double result = 0;
				if(opr.charAt(i) == '*') {
					result = a*b;
				}else if(opr.charAt(i) == '/') {
					result = a/b;
				}else if(opr.charAt(i) == '+') {
					result = a+b;
				}else if(opr.charAt(i) == '-') {
					result = a-b;
				}
				deque.addLast(result);
			}
		}
		
		System.out.printf("%.2f", deque.pollLast());
		
	}
}