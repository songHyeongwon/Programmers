package lineFintech;

import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution3().solution(5, 25)));
	}
	static int[][] arr = null;
	static boolean[][] isCheck = null;
	static int[][] dp = null;
	static int dpMax = 0;
	
	public int[] solution(int n, int k) {
		arr = new int[n][n];
		dp = new int[n][n];
		isCheck = new boolean[n][n];
		
		arr[0][0] = 1;
		isCheck[0][0] = true;
		
		setDp(0 , 0);
		dp(2);
		
		//정답 가져오기
        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == k) {
					answer[0] = i+1;
					answer[1] = j+1;
					break;
				}
			}
		}
        return answer;
    }
	
	
	public void dp(int t) {
		if(t-1 > arr.length * arr.length) return;
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(dpMax == dp[j][i]) {
					arr[j][i] = t;
					isCheck[j][i] = true;
					getDp(j , i);
					dp(t+1);
					return;
				}
			}
		}
	}
	
	public void getDp(int y , int x) {
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(!isCheck[i][j]) {
					int a = Math.abs(i - y);
					int b = Math.abs(j - x);
					dp[i][j] = Math.min(dp[i][j], (int) a+b);
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		print(arr);
		dpMax = max;
	}
	
	public void setDp(int y , int x) {
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(!isCheck[i][j]) {
					int a = Math.abs(i - y);
					int b = Math.abs(j - x);
					dp[i][j] = Math.max(dp[i][j], (int) a+b);
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		dpMax = max;
	}
	
	
	public void print(int[][] arr) {
		for(int[] k : arr) {
			System.out.println(Arrays.toString(k));
		}
		System.out.println();
	}
}
