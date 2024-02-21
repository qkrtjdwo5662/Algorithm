import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int l;
	static int c;
	static HashSet<Character> set;
	static String[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		
		arr = new String[c];
		visited = new boolean[c];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		
		backtrack(0, 0 , new StringBuilder());
		System.out.println(sb);
	}
	static boolean check(String s) {
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				a ++;
			}else b++;
		}
		
		if(a < 1 || b < 2) return false;
		else return true;
		
		
		
	}
	
	static void backtrack(int depth, int index, StringBuilder s) {
		if(depth == l) {
			if(check(s.toString())) {
				sb.append(s).append("\n");
			}
			return;
		}
		
		for (int i = index; i < c; i++) {
			if(!visited[i]) {
				visited[i] = true;
				s.append(arr[i]);
				backtrack(depth + 1, i, s);
				s.deleteCharAt(s.length() -1);
				visited[i] = false;
			}
		}
	}
}