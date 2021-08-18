package lavel1;
//https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
import java.util.ArrayList;
class Solution2 {
    public int solution(int[][] board, int[] moves) {
        int[][] newBoard = new int[board.length][board.length];
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 0; i<board.length ; i++) {
			for(int k = 0; k<board.length ; k++) {
				newBoard[k][i] = board[i][k];
			}
		}
		
		for(int i =0; i<moves.length; i++) {
			int count = 0;
			while (true) {
				if(count == board.length) {
					break;
				}
				if(newBoard[moves[i]-1][count] > 0) {
					arr.add(newBoard[moves[i]-1][count]);
					newBoard[moves[i]-1][count] = 0;
					break;
				}
				count++;
			}
		}
		//[4, 3, 1, 3, 4, 2, 4, 4]
		int k = arr.size();
		getAnswer(arr, 0);
		int j = arr.size();
        return k-j;
    }
    
    public static int getAnswer(ArrayList<Integer> arr, int result) {
		if(arr.size() == 0) return 0;
		
		for(int i = 0; i<arr.size()-1; i++) {
			if(arr.get(i) == arr.get(i+1)) {
				result = 1;
				arr.remove(i+1);
				arr.remove(i);
				result += getAnswer(arr , result);
			}
		}
		return result;
	}
}