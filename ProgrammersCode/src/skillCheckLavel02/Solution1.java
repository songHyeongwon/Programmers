package skillCheckLavel02;

import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		//int[][] arr = {{0,0,1,1},{1,1,1,1}};
		
		int[][] arr ={{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
		System.out.println(new Solution1().solution(arr));
	}
	public int solution(int [][] board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row +1][col +1];
        
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		dp[i+1][j+1] = board[i][j];
			}
		}
        
        for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if(dp[i][j] != 0) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
        /*for(int[] k : dp) {
        	System.out.println(Arrays.toString(k));
        }*/
        return answer * answer;
    }
}
