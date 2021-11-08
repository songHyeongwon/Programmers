package lavel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//https://programmers.co.kr/learn/courses/30/lessons/86052
public class Solution27 {
	public static void main(String[] args) {
		String[] arr = {"R" , "R"};
		
		System.out.println(Arrays.toString(new Solution27().solution(arr)));
	}
	static int COL;
	static int ROW;
	// 0 : L , 1 : U , 2 : R , 3 : D
	int[] xIndex = new int[]{-1,0,1,0};
	int[] yIndex = new int[]{0,-1,0,1};
	static boolean[][][] isCheck = null;
	
	public int[] solution(String[] grid) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		COL = grid.length;
		ROW = grid[0].length();
		// 행 ,열, 들어온 방향
		// 0 : L , 1 : U , 2 : R , 3 : D
		isCheck = new boolean[COL][ROW][4];
		for (int i = 0; i < COL; i++) {
			for (int j = 0; j < ROW; j++) {
				for (int k = 0; k < 4; k++) {
					if(!isCheck[i][j][k]) {
						list.add(getCnt(grid, i , j, k));
					}
				}
			}
		}
        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

	private Integer getCnt(String[] grid, int i, int j, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		while(true) {
			if(isCheck[i][j][k]) break;
			
			isCheck[i][j][k] = true;//같은곳 같은방향은 이미 들어온 경우
			count++;
			
			//방향수정
			if(grid[i].charAt(j) == 'L') {
				k = k==0 ? 3 : k-1;
			} else if(grid[i].charAt(j) == 'R') {
				k = k==3 ? 0 : k+1;
			}
			
			//위치수정
			i = (i + xIndex[k] + COL) % COL;
			j = (j + yIndex[k] + ROW) % ROW;
		}
		
		return count;
	}
}
