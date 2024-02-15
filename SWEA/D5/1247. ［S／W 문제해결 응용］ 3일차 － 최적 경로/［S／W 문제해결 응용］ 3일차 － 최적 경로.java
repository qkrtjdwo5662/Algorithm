import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static boolean[] visited;
	static int[] house;
	static int[] office;
	static int[][] arr;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			office = new int[2];
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			office[0] = x;
			office[1] = y;
			
			house = new int[2];
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			house[0] = x;
			house[1] = y;
			
			arr = new int[n][2];
			for (int j = 0; j < n; j++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				arr[j][0] = x;
				arr[j][1] = y;
			}
			visited = new boolean[n];
			answer = Integer.MAX_VALUE;
			
			backtrack(0, new ArrayList<>());
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static int getTotal(ArrayList<Integer> list) {
		int total = 0;
		
		int x1 = office[0];
		int y1=  office[1];
		
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			
			int x2 = arr[num][0];
			int y2 = arr[num][1];
			
			total += Math.abs(x2 - x1) + Math.abs(y2 - y1);
			
			x1 = x2;
			y1 = y2;
		}
		
		total += Math.abs(house[0] - x1) + Math.abs(house[1] - y1);
		
		return total;
	}
	
	static void backtrack(int depth, ArrayList<Integer> list) {
		if(depth == n) {
			answer= Math.min(answer, getTotal(list));
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list.add(i);
				backtrack(depth+1, list);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
}