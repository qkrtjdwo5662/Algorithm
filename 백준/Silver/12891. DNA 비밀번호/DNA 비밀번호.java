import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int s;
	static int p;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		
		result = new int['Z' - 'A' + 1];
		int[] count = new int['Z' - 'A' + 1];
		
		// A, C, G, T
		st = new StringTokenizer(br.readLine());
		result['A' - 'A'] = Integer.parseInt(st.nextToken());
		result['C' - 'A'] = Integer.parseInt(st.nextToken());
		result['G' - 'A'] = Integer.parseInt(st.nextToken());
		result['T' - 'A'] = Integer.parseInt(st.nextToken());
		
		int answer =0;
		
		for (int i = 0; i < p; i++) {
			count[str.charAt(i) - 'A'] ++;
		}
		
		if(countCheck(count)) {
			answer++;
		}
	
		
		int left = 0;
		int right = p;
		
		while(right < s) {
			count[str.charAt(left) - 'A'] --; // 앞에꺼 빼줘
			count[str.charAt(right) - 'A'] ++; // 뒤에꺼 새로 넣어
			
			if(countCheck(count)) {
				answer++;
			}
			
			left ++;
			right ++;
		}

		System.out.println(answer);
	}

	
	public static boolean countCheck(int[] count) {
		if(count['A' - 'A'] >= result['A' - 'A'] && count['C' - 'A'] >= result['C' - 'A']  && count['G' - 'A'] >= result['G' - 'A'] && count['T' - 'A'] >= result['T' -'A']) {
			return true;
		}
		
		return false;
	}
	
	
	
}