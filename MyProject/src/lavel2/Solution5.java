package lavel2;
///https://programmers.co.kr/learn/courses/30/lessons/68936?language=java
import java.util.Arrays;

public class Solution5 {
	public static void main(String[] args) {
		Solution5 solution5 = new Solution5();
		
		int[][] board = {
				{1,1,0,0},
				{1,0,0,0},
				{1,0,0,1},
				{1,1,1,1}};		
		System.out.println(Arrays.toString(solution5.solution(board)));
	}
	
	static int count0 = 0; //0°³ÀÇ °¹¼ö
	static int count1 = 0; //1°³ÀÇ °¹¼ö
	static boolean[][] check = null;
	public int[] solution(int[][] arr) {
		int row = arr.length;
		check = new boolean[row][row];
		
		goCompression(arr , row);
		
        int[] answer = new int[2];
        answer[0] = count0;
        answer[1] = count1;
        return answer;
    }
	private void goCompression(int[][] arr, int row) {
		if(row == 1) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(!check[i][j]) {
						if(arr[i][j] == 1) {
							count1++;
						} else {
							count0++;
						}
					}
				}
			}
			return;
		}
		for (int k = 0; k < arr.length; k+=row) {
			for (int k2 = 0; k2 < arr.length; k2+=row) {
				goCompression2(arr, row, k2, k , k2 + row, k + row);
			}
		}
		goCompression(arr , row/2);
	}
	
	public void goCompression2(int[][] arr, int row , int xIndexS, int yIndexS , int xIndexE, int yIndexE) {
		int temp0 = 0; //0ÀÇ °¹¼ö
		int temp1 = 0; //1ÀÇ °¹¼ö
		for (int i = yIndexS; i < yIndexE; i++) {
			for (int j = xIndexS; j < xIndexE; j++) {
				System.out.println(i + " / " + j);
				if(!check[i][j]) {
					if(arr[i][j] == 1) {
						temp1++;
					} else {
						temp0++;
					}
				}
			}
		}
		if(temp0 == row*row) {
			System.out.println("temp0 "+temp0);
			count0++;
			for (int i = yIndexS; i < yIndexE; i++) {
				for (int j = xIndexS; j < xIndexE; j++) {
					check[i][j] = true;
				}
			}
		}
		if(temp1 == row*row) {
			System.out.println("temp1 "+temp0);
			count1++;
			for (int i = yIndexS; i < yIndexE; i++) {
				for (int j = xIndexS; j < xIndexE; j++) {
					check[i][j] = true;
				}
			}
		}
	}
}
