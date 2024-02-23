import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static int[] arr;
	static HashMap<Integer, Integer> map;
	static int n;
	static int k;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken()); // 접시  수 
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수 
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 
		
		answer =0;
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
//		// 전체 무작위 선택 상황
//		if(allSet.size() >= k) {
//			answer = k;
//		}else answer = allSet.size();
//		
//		if(!allSet.contains(c)) {
//			answer = Math.max(answer, allSet.size() + 1);
//		}
		
		map = new HashMap<>();
		int left = 0;
		int right = left + k;
		
		// 기본 세팅
		for (int i = left; i < right; i++) {
			int num = arr[i];
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else map.put(num, map.get(num) + 1);
		}
		if(map.containsKey(c)) {
			answer = Math.max(answer, map.size());
		}else answer = Math.max(answer, map.size() + 1);
		
		
		// 연속적으로 선택 + 쿠폰 사용 상황
		while(left < n - 1) {
			if(map.get(arr[left]) > 1) {
				map.put(arr[left], map.get(arr[left]) - 1);
			}else map.remove(arr[left]);
			
			if(!map.containsKey(arr[right])) {
				map.put(arr[right], 1);
			}else map.put(arr[right], map.get(arr[right]) + 1);
			
			if(map.containsKey(c)) {
				answer = Math.max(answer, map.size());
			}else answer = Math.max(answer, map.size() + 1);
			
			left ++;
			right ++;
			
			right = right % n;
			
		}
		
		
		
		sb.append(answer).append("\n");
		System.out.println(sb);
		
	}
	
	
	
	
	
}