import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		char[] arr = new char[n];
		boolean[] visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = st.nextToken();
			arr[i] = s.charAt(0);
		}
		
		Arrays.sort(arr);
		backtrack(0, 0, arr, visited, new StringBuilder());
		
	}
	
	public static void backtrack(int depth, int index ,char[] arr, boolean[] visited, StringBuilder sb) {
		if(depth == m) {
			if(check(sb.toString())) {
				System.out.println(sb);
			}
			
			return;
		}
		
		for (int i = index; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sb.append(arr[i]);
				backtrack(depth + 1, i, arr, visited, sb);
				sb.deleteCharAt(sb.length()-1);
				visited[i] = false;
			}
		}
	}
	
	public static boolean check(String s) {
		int consonant = 0;
		int vowel = 0;
		
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				consonant += 1;
			}else vowel +=1;
		}
		
		if(consonant >=1 && vowel >=2) return true;
		else return false;
	}
}