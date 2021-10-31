package lavel2;
//https://programmers.co.kr/learn/courses/30/lessons/87377
import java.util.ArrayList;
import java.util.Arrays;

public class Solution31 {
	public static void main(String[] args) {
		Solution31 sol = new Solution31();
		//int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		String[] result = sol.solution(line);
		sol.print(result);
		
	}
	public void print(String[] arr) {
		for(String k : arr) {
			System.out.println(k);
		}
	}
	public void print(char[][] arr) {
		for(char[] k : arr) {
			System.out.println(new String(k));
		}
	}
	
	public String[] solution(int[][] line) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		//큰값 작은값을 담을 변수
		int xMax = Integer.MIN_VALUE;
		int xMin = Integer.MAX_VALUE;
		int yMax = Integer.MIN_VALUE;
		int yMin = Integer.MAX_VALUE;
		
		for (int i = 0; i < line.length; i++) {
			for (int j = i+1; j < line.length; j++) {
				long A = line[i][0];
				long B = line[i][1];
				long E = line[i][2];
				long C = line[j][0];
				long D = line[j][1];
				long F = line[j][2];
				
				if(i!=j && (A*D - B*C) != 0) {
					//값이 정수일때만
					long deno = (A*D) - (B*C);
					long num1 = (B*F) - (E*D);
					long num2 = (E*C) - (A*F);
					if(deno != 0 && (num1 % deno == 0 && num2 % deno == 0)) {
						long y = (E*C - A*F) / (A*D - B*C);
						long x = (B*F - E*D) / (A*D - B*C);
						int[] temp = new int[2];
						temp[0] = (int)y;
						temp[1] = (int)x;
						yMax = Math.max(yMax, temp[0]);
						yMin = Math.min(yMin, temp[0]);
						xMax = Math.max(xMax, temp[1]);
						xMin = Math.min(xMin, temp[1]);
						list.add(temp);
					}
				}
			}
		}
		char[][] charArr = new char[yMax - yMin +1][xMax - xMin +1];
		for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < charArr[i].length; j++) {
				charArr[i][j] = '.';
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			int y = list.get(i)[0];
			int x = list.get(i)[1];
			charArr[y - yMin][x - xMin] = '*';
		}
		
        String[] answer = new String[charArr.length];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = new String(charArr[answer.length-1-i]);
		}
        
        return answer;
    }
}
