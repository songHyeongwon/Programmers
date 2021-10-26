package step15;

import java.util.Scanner;

public class Main10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[][] dp = new long[N+1][10];
		long count = 0;
		long mod = 1000000000;
		
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][1] % mod;
				} else if(j == 9) {
					dp[i][j] = dp[i-1][8] % mod;
				} else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
				}
				if(i == N) {
					count += dp[i][j];
				}
			}
		}
		if(N == 1) {
			System.out.println(9);
		} else {
			System.out.println(count % mod);
		}
		sc.close();
	}
}
