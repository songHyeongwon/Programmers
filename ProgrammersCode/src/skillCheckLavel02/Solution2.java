package skillCheckLavel02;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution2().solution(6)));
	}
	public int[] solution(int n) {
		int[][] arr = new int[n][n];
		int maxNum = n*(n+1) / 2;
		//System.out.println(maxNum);
		
		int num = 1;
		int x = -1;
		int y = 0;
		
		for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 	
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
		for(int[] k : arr) {
			System.out.println(Arrays.toString(k));
		}
		
        int[] answer = new int[maxNum];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] !=0) {
					answer[idx++] = arr[i][j];
				}
			}
		}
        return answer;
    }
}
