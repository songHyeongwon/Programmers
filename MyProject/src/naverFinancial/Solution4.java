package naverFinancial;

import java.util.Arrays;

public class Solution4 {
	public static void main(String[] args) {
		int[][] arr = {{1, -7, -2, 1, -1},{2, 3, 0, -1, -2},{1, -1, 6, -1, -2},{-1, 1, -2, 0, 4},{-10, 5, -3, -1, 1}};
		
		System.out.println(new Solution4().solution(arr));
	}
	
	static int[][] dp = null;
	static int[][] arr = null;
	public int solution(int[][] board) {
		dp = new int[board.length+1][board.length+1];
		dp[0][0] = board[0][0];
		arr = board;
		getDp(0 , 0);
        int answer = dp[board.length][board.length];
        return answer;
    }
	private void getDp(int x, int y) {
		// TODO Auto-generated method stub

	}
	private void print(int[][]arr) {
		for(int[] k : arr) {
			System.out.println(Arrays.toString(k));
		}
	}
	
}
