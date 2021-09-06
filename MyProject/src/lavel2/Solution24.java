package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/77485?language=java
import java.util.Arrays;

public class Solution24 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution24().solution(7, 6, new int[][]{{1,1,7,6 }})));
	}
	
	static int[][] quer = null;
	public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        quer = new int[rows][columns];
        int number = 1;
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j< columns; j++) {
        		quer[i][j] = number++;
        	}
        }        
        for(int i = 0; i < queries.length; i++) {
	        answer[i] = getAnswer(rows , columns, queries[i]);
        	//printArray(quer);
        }
        
        return answer;
    }
	private int getAnswer(int rows, int columns, int[] is) {
		//[2,2,5,4]
		int y1 = is[0];//2
		int x1 = is[1];//2
		int y2 = is[2];//4
		int x2 = is[3];//5
		int[][] quer2 = new int[y2 - y1 +1][x2- x1 +1];
		for(int i = 0; i < quer2.length; i++) {
			for(int j = 0; j < quer2[i].length; j++) {
				//상단 우로
				if(i == 0 && i < j && isChekc(i+y1 -1, j+x1 -1 -1)) {
					quer2[i][j] = quer[i+y1 -1 ][j+x1 -1 -1];
				}
				//상단 아래로
				if(j == quer2[i].length-1 && i != 0 && isChekc(i+y1 -1 -1,j+x1 -1)) {
					quer2[i][j] = quer[i+y1 -1 -1][j+x1 -1 ];
				}
				//하단 좌로
				if(i == quer2.length-1 && j != quer2[i].length-1 && isChekc(i+y1 -1 ,j+x1)) {
					quer2[i][j] = quer[i+y1 -1 ][j+x1];
				}
				//하단 위로
				if(j == 0 && i != quer2.length-1 && isChekc(i+y1 ,j+x1 -1)) {
					quer2[i][j] = quer[i+y1][j+x1 -1 ];
				}
				//가운데 자리는 필요없다
				continue;
			}
		}
		//printArray(quer2);
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < quer2.length; i++) {
			for(int j = 0; j < quer2[i].length; j++) {
				if(quer2[i][j] !=0 && isChekc(i+y1 -1 ,j+x1 -1)) {
					quer[i+y1 -1 ][j+x1 -1 ] = quer2[i][j];
					result = Math.min(result, quer2[i][j]);
				}
			}
		}
		//printArray(quer);
		return result;
	}
	private boolean isChekc(int i, int j) {
		if(i >= 0 && i < quer.length && j >=0 && j <quer[0].length) {
			return true;
		}
		return false;
	}
	public void printArray(int[][] quer) {
		for(int i = 0; i < quer.length; i++) {
        	System.out.println(Arrays.toString(quer[i]));
        }
	}
}
