import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int win;
	static int lose;
	static ArrayList<Integer> list;
	static boolean[] visited;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			visited = new boolean[19];
			list = new ArrayList<>();
			
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
				visited[num] = true;
			}

			win = 0;
			lose = 0;
			
			for (int j = 1; j <= 18; j++) {
				if(!visited[j]) {
					visited[j] = true;
					
					if(list.get(0) > j) {
						backtrack(1, list.get(0) + j, 0);
					}else {
						backtrack(1, 0, list.get(0) + j);
					}
					
					visited[j] = false;
				}
			}
			sb.append("#").append(i).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
		
		
	}
	
	static void backtrack(int depth, int gyu, int in) {
		if(depth == 9) {
			if(gyu > in) win++;
			else if(gyu < in) lose++;
			return;
		}
		
		for (int i = 1; i <= 18; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				if(list.get(depth) > i) {
					backtrack(depth+1, gyu + list.get(depth) + i, in);
				}else {
					backtrack(depth+1, gyu, in + list.get(depth) + i);
				}
				
				visited[i] = false;
			}
		}
		
		
	}
}