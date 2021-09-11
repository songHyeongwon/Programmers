package kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution6 {
	public static void main(String[] args) {
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		System.out.println(new Solution6().solution(board, skill));
	}
	
	
	public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] dp = new int[board.length][board[0].length+1];
        
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[i].length; j++) {
                dp[i][j] = board[i][j];
            }
        }
        
        
        //여기서 250000
        for(int i = 0; i< skill.length; i++) {
            skill(dp , skill[i]);
        }
        //여기서 1000*1000
        for(int i = 0; i< dp.length; i++) {
        	answer+= board[i][dp.length-1];
        }

        return answer;
    }
    public void skill(int[][] board, int[] skill) {
        int skillCase = skill[0];
        int r1 = skill[1];
        int c1 = skill[2];
        int r2 = skill[3];
        int c2 = skill[4];
        int degree = skill[5];
        int count = 0;
        for(int i = r1; i <= r2; i++) {
            for(int j = c1; j <= c2; j++) {
                if(skillCase == 1) {
                    board[i][j] = board[i][j]-degree;
                } else {
                    board[i][j] = board[i][j]+degree;
                }
            }
            for(int j = 0; j < board[i].length-1; j++) {
            	if(board[i][j] > 0) {
            		count++;
            	}
            }
            board[i][board.length-1] = count;
            count = 0;
        }
    }
}
