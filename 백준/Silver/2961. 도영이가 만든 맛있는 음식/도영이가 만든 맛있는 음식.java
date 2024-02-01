import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int n;
	static int[] sourArr;
	static int[] bitterArr;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		
		sourArr = new int[n];
		bitterArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sour = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			
			sourArr[i] = sour;
			bitterArr[i] = bitter;
		}
		
		answer = 1_000_000_000;
		dfs(1, 0, 0);
		System.out.println(answer);
		
	}
	
	public static void dfs(int totalSour, int totalBitter, int depth) {
		if(depth == n) {
			if(totalSour == 1 || totalBitter == 0) return;
			answer = Math.min(answer, Math.abs(totalSour - totalBitter));
			return ;
		}
		
		dfs(totalSour*sourArr[depth], totalBitter + bitterArr[depth], depth+1);
		dfs(totalSour, totalBitter, depth+1);
		
	}
}