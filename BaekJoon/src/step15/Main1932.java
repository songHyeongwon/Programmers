package step15;

import java.util.Scanner;

public class Main1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				dp[i-1][j] += Math.max(dp[i][j], dp[i][j+1]);
			}
		}
		
		System.out.println(dp[0][0]);
		sc.close();
	}
}
