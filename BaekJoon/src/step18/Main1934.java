package step18;

import java.util.Scanner;

public class Main1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(getAns(a, b));
		}
		sc.close();
	}

	private static int getAns(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int cnt = 0;
		while (true) {
			if (min * (++cnt) % max == 0) {
				return min * cnt;
			}
		}
	}
}
