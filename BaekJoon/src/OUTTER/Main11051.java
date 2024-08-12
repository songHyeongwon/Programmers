package OUTTER;

import java.util.Scanner;

public class Main11051 {
	static int[][] dp;
	static int NUM = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		dp = new int[N+1][K+1];
		
		System.out.println(BC(N, K));
	}
	private static int BC(int n, int k) {
		if(dp[n][k] > 0) {
			return dp[n][k];
		}
		
		if(n==k || k==0) {
			return dp[n][k] = 1;
		}
		return dp[n][k] = (BC(n-1 , k-1) + BC(n-1 , k)) % NUM ;
	}
}
