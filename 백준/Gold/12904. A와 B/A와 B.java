import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String s;
	static String t;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s = br.readLine();
		t = br.readLine();
		flag = false;
		
		dfs(new StringBuilder(t));
			
		if(flag) {
			sb.append("1").append("\n");
		}else sb.append("0").append("\n");
		
		System.out.println(sb);
	}
	
	static void dfs(StringBuilder now) {
		if(flag) return;
		
		if(now.length() == s.length()) {
			if(now.toString().equals(s)) {
				flag = true;
			}
			return;
		}
		
		
		if(now.charAt(now.length() - 1) == 'A') {
			now = now.deleteCharAt(now.length() - 1);
			dfs(now);
		}else if(now.charAt(now.length() -1) == 'B') {
			now = now.deleteCharAt(now.length() -1);
			now = now.reverse();
			dfs(now);
		}
		
	}
}