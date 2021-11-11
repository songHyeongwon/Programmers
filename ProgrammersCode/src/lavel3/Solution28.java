package lavel3;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/42898
public class Solution28 {
	public static void main(String[] args) {
		System.out.println(new Solution28().solution(4, 3, new int[][] {{2, 2}}));
	}
	
	int MOD = 1000000007;
	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n+1][m+1];
		for(int[] k : puddles) {
			dp[k[1]][k[0]] = -1;
		}
		dp[1][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(dp[i][j] != -1) {
					if(j-1  > 0 && dp[i][j-1] != -1) dp[i][j] += dp[i][j-1] % MOD;
					if(i-1  > 0 && dp[i-1][j] != -1) dp[i][j] += dp[i-1][j] % MOD;
				}
			}
		}
		
		/*for(int[] k : dp) {
			System.out.println(Arrays.toString(k));
		}*/
		return dp[n][m] % MOD;
    }
}
