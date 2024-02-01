import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static String[] decimal = {"2", "3", "5", "7"};
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < decimal.length; i++) {
			backtrack(1, n, decimal[i]);
		}
		
	}
	
	public static boolean check(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	public static void backtrack(int depth, int n, String s) {
		if(!check(Integer.parseInt(s))) {
			return;
		}
		
		if(depth == n) {
			System.out.println(s);
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			backtrack(depth +1, n, s+i);
		}
	}
}