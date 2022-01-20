package lavel3;

import java.util.Scanner;

//https://programmers.co.kr/learn/courses/30/lessons/92344?language=java
//https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
public class Solution32 {
	public static void main(String[] args) {
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		System.out.println(new Solution32().solution(board, skill));
	}
	
	
	public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n+1][m+1];
        
        for(int [] row : skill) {
        	int skillCase = row[0];
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];
            int degree = skillCase == 1 ? -row[5] : row[5];
            
            for(int i = r1; i <= r2; ++i) {
            	dp[i][c1] += degree;
            	dp[i][c2 + 1] += -degree;
            }
        }
        for(int i = 0; i < n; ++i) {
        	for(int j = 0; j < m; ++j) {
        		if(j != 0) dp[i][j] += dp[i][j-1];
        		board[i][j] += dp[i][j];
        		if(board[i][j] > 0) answer++;
        	}
        }

        return answer;
    }
	
	//테스트용
	public void test(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr2 = { 1, 5, 8, 10, 24, 3, 5, 100, 99, 7 };
		int a = sc.nextInt();
		int b = sc.nextInt();

		// 누적 합 구하기
		// 배열의 크기를 + 1하는 이유는, 0번 인덱스 ~ n번 인덱스의 구간합도 구할 수 있게 만들기 위함이다.
		int[] prefix_sum = new int[11];
		int[] prefix_sum2 = new int[11];
		for (int i = 1; i < arr.length; i++) {
			prefix_sum[i] += prefix_sum[i - 1] + arr[i];
			prefix_sum2[i] += prefix_sum2[i - 1] + arr2[i];
		}
		
		// 구간 합 구하기
		System.out.println(prefix_sum[b] - prefix_sum[a - 1]);
		System.out.println(prefix_sum2[b] - prefix_sum2[a - 1]);
		sc.close();
	}
}
