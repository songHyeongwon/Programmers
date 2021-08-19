package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/12905?language=java

public class Solution4 {
	public static void main(String[] args) {
		Solution4 Solution4 = new Solution4();
		
		int [][]board = {
				{1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1}, 
				{0, 0, 1, 1, 1}};		
		System.out.println(Solution4.solution(board));
	}
	//√‚√≥ https://soobarkbar.tistory.com/164 
	public int solution(int [][]board) {
		int answer = 0;
		int row = board.length;
		int col = board[0].length;
		int[][] map = new int[row+1][col+1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i+1][j+1] = board[i][j];
			}
		}
		
		/*for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if(map[i][j] != 0) {
					map[i][j] = Math.min(Math.min(map[i -1][j], map[i][j-1]), map[i-1][j-1]) + 1;
					answer = Math.max(answer, map[i][j]);
				}
			}
		}
		/*System.out.println();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		
		return answer * answer;
    }

}
