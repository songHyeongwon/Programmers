package lavel3;
//https://programmers.co.kr/learn/courses/30/lessons/12907?language=java
public class Solution5 {
	public static void main(String[] args) {
		int n = 6;
		
		System.out.println(new Solution5().solution(n));
	}
	
    public long solution(int n) {
        /* 피보나치 수열을 구현한다
          n 1 = 1
          n 2 = 2
          n 3 = 3
          n 4 = 5
          n 5 = 8
        */
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<2001; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}
