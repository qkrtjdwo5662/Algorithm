import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int a = n/5;
		int b = 0;
		int answer = 987654321;
		
		while(a >= 0) {
			int remain = n - 5*a;
			
			if(remain % 2 == 0) {
				b = remain / 2;
				answer = Math.min(answer, a + b);
			}
			
			a--;
		}
		
		if(answer == 987654321) sb.append(-1).append("\n");
		else sb.append(answer).append("\n");
		
		System.out.println(sb);
	}
}