package step16;

import java.util.Scanner;

public class Main2579 {
	static int[] dp = null;
	static int[] arr = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[301];
		dp = new int[301];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1] , arr[2]) + arr[3];
		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1] , dp[i-2]) + arr[i];
		}
		System.out.println(dp[n]);
		sc.close();
	}
}
