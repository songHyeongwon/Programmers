package lavel1;
//https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
import java.util.ArrayList;
import java.util.Stack;
class Solution2 {
	public static void main(String[] args) {
		int[][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] b = {1,5,3,5,1,2,1,4};
		
		System.out.println(new Solution2().solution(arr, b));
	}
	
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Stack<Integer>> arr = new ArrayList<Stack<Integer>>();
        Stack<Integer> scoreStack = new Stack<Integer>();
        for(int i =0; i < board[0].length; i++) {
        	arr.add(new Stack<Integer>());
        	for(int j = board.length-1; j >=0 ; j--) {
        		if(board[j][i] != 0) {//0은 빈거니까 굳이 넣을필요 없음
        			arr.get(i).add(board[j][i]);
        		}
            }
        }
        //스택확인 출력용
        /*for(int i =0; i < board[0].length; i++) {
        	System.out.println(arr.get(i).toString());
        }*/
        scoreStack.add(-1);//널 오류나지않게 없는값 하나 입력
        for(int i : moves) {
        	//해당스택이 비어있지 않다면
        	if(!arr.get(i-1).isEmpty()) {
        		int inputNum = arr.get(i-1).pop();
        		//System.out.println(inputNum);
    			int resultNum = scoreStack.pop();
    			if(resultNum == inputNum) {
    				answer += 2;
    			} else {
    				//둘다 다시 넣은다(확인 후 빼나 빼고 다시 넣나)
    				scoreStack.add(resultNum);
    				scoreStack.add(inputNum);
    			}
        	}
        }
        
        return answer;
    }
	
	
    /*public int solution(int[][] board, int[] moves) {
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
	}*/
}