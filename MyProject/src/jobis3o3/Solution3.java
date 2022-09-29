package jobis3o3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		
		System.out.println(Arrays.toString(sol.solution(new String[]{
				"EEEEMEEEE",
				"EEEEEEEEM",
				"EEEEEEMEE", 
				"EEEEEEEEE", 
				"EEMEEEEEM",
				"EEEEEEEEE",
				"MEEEEEMEE",
				"EEEMEEEEE",
				"MEEEEEMEE"}, 0, 0)));
		//System.out.println(Arrays.toString(sol.solution(new String[]{"EEEEE","EEMEE","EEEEE", "EEEEE"}, 2, 0)));
		//System.out.println(Arrays.toString(sol.solution(new String[]{"MME","EEE","EME"}, 0, 0)));

	}
	//8방향 인덱스 배열
    int [][] deltas = {{-1, -1}, {-1, 0}, {-1, 1},
			   {0, 1}, {1, 1}, {1, 0}, {1,-1}, {0, -1}};

	static boolean[][] isCheck;
	
    public String[] solution(String[] board, int y, int x) {
        String[] answer = new String[board.length];
        
        //만약 지뢰를 밟았다면 연산후 리턴
        if(board[y].charAt(x) == 'M') {
        	for (int i = 0; i < answer.length; i++) {
        		answer[i] = board[i];
        		if(i == y) {
        			char[] temp = board[i].toCharArray().clone();
        			temp[x] = 'X';
        			answer[i] = new String(temp);
        		}
			}
        	return answer;
        }
        
        
        //마인 갯수 배열
        int[][] mainArr = getMainArr(board);
        //보여도 되는지 체크
    	isCheck = new boolean[board.length][board[0].length()];
    	//재귀함수 시작
        getIsCheck(board, mainArr , y, x);
        
        for (int i = 0; i < isCheck.length; i++) {
        	String temp = "";
			for (int j = 0; j < isCheck[i].length; j++) {
				if(isCheck[i][j]) {
					if(mainArr[i][j] > 0) {
						temp += mainArr[i][j];
					} else {
						temp += "B";
					}
				} else {
					temp += "E";
				}
			}
			answer[i] = temp;
		}
        
        return answer;
    }
    //메인 재귀 함수
    public void getIsCheck(String[] board , int[][] mainArr, int y ,int x) {
    	if(y < 0 || y > board.length-1) return;
    	if(x < 0 || x > board[y].length()-1) return;
    	if(isCheck[y][x]) return;
    	if(mainArr[y][x] > -1) {
    		isCheck[y][x] = true;
    	}
    	if(mainArr[y][x] != 0) return;
    	
    	for (int i = 0; i < deltas.length; i++) {
    		getIsCheck(board , mainArr , y + deltas[i][0] , x + deltas[i][1]);
		}
    }
    //마인 갯수 배열 가져오기
    public int[][] getMainArr(String[] board) {
        int[][] mainArr = new int[board.length][board[0].length()];
        for (int i = 0; i < mainArr.length; i++) {
			for (int j = 0; j < mainArr[i].length; j++) {
				mainArr[i][j] = getMainCnt(board , i, j);
			}
		}
        return mainArr;
    }

    //블럭 8방향 지뢰찾기
	private int getMainCnt(String[] board, int i, int j) {
		int result = 0;
		
		if(board[i].charAt(j) == 'M') return -1;
		
		for (int k = 0; k < deltas.length; k++) {
			if(i + deltas[k][0] > -1 
					&& i + deltas[k][0] < board.length 
					&& j + deltas[k][1] > -1 
					&& j + deltas[k][1] < board[i].length()) {
				if(board[i + deltas[k][0]].charAt(j + deltas[k][1]) == 'M') result++;
			}
		}
		
		return result;
	}
	//확인용 프린터
	public static void print(int[][] mainArr) {
		for(int[] a : mainArr) {
			System.out.println(Arrays.toString(a));
		}
	}
}