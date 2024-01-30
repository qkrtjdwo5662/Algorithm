import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		BigInteger answer = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
		
		sb.append(answer).append("\n");
		
		if(n <= 20) {
			hanoi(n, 1, 2, 3);
		}
		
		
		System.out.println(sb);
		
	}
	
	static void hanoi(int count, int from, int temp, int to) {
		if(count == 0){
			return;
		}
		
		hanoi(count-1, from, to , temp);
		
		sb.append(from).append(" ").append(to).append("\n");
		
		hanoi(count-1, temp,from ,to);
	}
}