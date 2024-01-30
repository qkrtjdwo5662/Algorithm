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

		int[] arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int el = Integer.parseInt(st.nextToken());
			arr[i] = el;
		}

		st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			// 1:남 2:여

			int num = Integer.parseInt(st.nextToken());
			// 받는 수

			// 남자는 받는 수의 배수의 상태 바꿈
			// 여자는 받는 수를 위치로

			run(gender, num, arr, n);
		}

		if (n > 20) {
			int index = 1;

			while (index < n) {
				if (index % 20 == 0) {
					sb.append(arr[index]);
					sb.append("\n");
				} else {
					sb.append(arr[index]).append(" ");
				}
				index++;
			}
			sb.append(arr[n]).append("\n");
			
		} else {
			for (int i = 1; i < n; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append(arr[n]).append("\n");
		}

		System.out.println(sb);

	}

	public static void run(int gender, int num, int[] arr, int n) {
		if (gender == 1) {
			// 남자
			int index = 1;

			while (true) {
				if (num * index > n)
					break;

				if (arr[num * index] == 1) {
					arr[num * index] = 0;
				} else {
					arr[num * index] = 1;
				}
				index++;
			}
		} else if (gender == 2) {
			// 여자
			int index = 0;

			while (true) {
				if (num - (index + 1) < 1 || num + (index + 1) > n) {
					break;
				}

				if (arr[num - (index + 1)] != arr[num + (index + 1)]) {
					break;
				}

				index++;
			}

			for (int i = num - index; i <= num + index; i++) {
				if (arr[i] == 1) {
					arr[i] = 0;
				} else
					arr[i] = 1;
			}

		}

	}
}