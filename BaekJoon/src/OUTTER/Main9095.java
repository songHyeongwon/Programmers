package OUTTER;

import java.util.Scanner;

public class Main9095 {
	static int[] dp = null;
	public static void main(String[] args) {
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
		sc.close();
	}
}
