package step16;

import java.util.Scanner;

public class Main24416 {

	static int fibCnt = 0;
	static int fibonacciCnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fib(n);
		fib_dp(n);
		System.out.println(fibCnt + " " + fibonacciCnt);
		sc.close();
	}

	public static int fib(int n) {
		if (n == 1 || n == 2) {
			fibCnt++;
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static int fib_dp(int n) {
		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			fibonacciCnt++;
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}
