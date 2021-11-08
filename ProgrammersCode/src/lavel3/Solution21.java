package lavel3;

import java.util.ArrayList;
import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/60061
public class Solution21 {
	public static void main(String[] args) {
		int[][] arr = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		
		int[][] result = new Solution21().solution(5, arr);
		
		for(int[] k : result) {
			System.out.println(Arrays.toString(k));
		}
	}
	//https://leveloper.tistory.com/100 ��ó
	ArrayList<int[]> arr = new ArrayList<int[]>();
	static boolean[][] cols = null;
	static boolean[][] rows = null;
	int n;
	
	public int[][] solution(int n, int[][] build_frame) {
		cols = new boolean[n+3][n+3];
		rows  = new boolean[n+3][n+3];
		this.n = n;
		int count = 0;
		for(int[] from : build_frame) {
			int x = from[0]+1;
			int y = from[1]+1;
			
			if(from[2] == 0) {
				//���
				if(from[3] == 1 && isExistCol(x,y)) {
					//����� ��ġ�Ѵ�.
					cols[x][y] = true;
					count++;
				} 
				if(from[3] == 0 && canRemove(x, y, from[2])) {
					//����� �����Ѵ�.
					cols[x][y] = false;
					count--;
				}
				
			} else {
				//��
				if(from[3] == 1 && isExistRow(x,y)) {
					//���� ��ġ�Ѵ�.
					rows[x][y] = true;
					count++;
				} 
				if(from[3] == 0 && canRemove(x, y, from[2])) {
					//���� �����Ѵ�.
					rows[x][y] = false;
					count--;
				}
			}
		}
		
		
        int[][] answer = new int[count][3];
        
        int index = 0; 
        for (int i = 1; i <= n + 1; i++) {
        	// ���� �ִ� ��հ� �� �迭�� ���� 
        	for (int j = 1; j <= n + 1; j++) {
        		if (cols[i][j]) answer[index++] = new int[]{i - 1, j - 1, 0}; 
        		if (rows[i][j]) answer[index++] = new int[]{i - 1, j - 1, 1}; 
        	} 
        }
        return answer;
    }

	private boolean canRemove(int x, int y, int type) {
		boolean result = true;
		if (type == 0) {
			cols[x][y] = false; 
		} else {
			rows[x][y] = false; 
		}
		
		loop: for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				if (cols[i][j] && !isExistCol(i, j)) {
					result = false; 
					break loop; 
				} 
				if (rows[i][j] && !isExistRow(i, j)) {
					result = false; 
					break loop; 
				} 
			} 
		} 
		if (type == 0) {
			cols[x][y] = true; // �����ߴ� ������ ���󺹱� 
		} else {
			rows[x][y] = true; 
		}
		
		return result;
	}

	private boolean isExistRow(int x, int y) {
		// TODO Auto-generated method stub
		return cols[x][y - 1] || cols[x + 1][y - 1] || (rows[x - 1][y] && rows[x + 1][y]);
	}
	
	private boolean isExistCol(int x, int y) {
		// TODO Auto-generated method stub
		return y == 1 || cols[x][y - 1] || rows[x][y] || rows[x - 1][y];
	}
}
