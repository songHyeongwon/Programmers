package step16;

import java.util.Scanner;

public class Main1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[] dp = new int[n+1];
		dp[0] = dp[1] = 0;
		
		for (int i = 2; i < dp.length; i++) {
			int min;
			int two = Integer.MAX_VALUE;
			int three = Integer.MAX_VALUE;
			
			if(i % 3 == 0) three = dp[i/3]+1;
			if(i % 2 == 0) two = dp[i/2]+1;
			
			min = dp[i-1] +1;
			
			int result = Math.min(min, Math.min(two, three));
			dp[i] = result;
		}
		System.out.println(dp[n]);
	}
}
