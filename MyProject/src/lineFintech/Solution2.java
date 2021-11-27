package lineFintech;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 1, 4, 3, 2, 2, 1};
		System.out.println(new Solution2().solution(arr));
		
		//System.out.println(new Solution2().isCheck(new int[] {3,2,1}));
		
	}
	static int temp = (10*10*10*10*10*10*10*10*10) + 7;
	
	public int solution(int[] arr) {
        int answer = 0;
        
        int gap = 3;
        while(gap < arr.length) {
        	for (int i = 0; i < arr.length - gap +1; i++) {
				int[] temp = new int[gap];
				int idx = i;
				for (int j = 0; j < temp.length; j++) {
					temp[j] = arr[idx++];
				}
				if(isCheck(temp)) {
					System.out.println(Arrays.toString(temp));
					answer++;
				}
			}
        	gap++;
        }
        
        return answer;
    }
	public boolean isCheck(int[] arr) {
		
		boolean result = false;
		
		int upCnt = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1] < arr[i] && !result) {
				upCnt++;
			}
			if(arr[i-1] >= arr[i] && upCnt > 0) {
				result = true;
			}
			
			if(result && arr[i-1] <= arr[i]) {
				return false;
			}
		}
		
		return result;
	}
	
	/*public int solution(int[] arr) {
        int answer = 0;
        int[][] dp = new int[arr.length][2];        
        boolean[] isCheck = new boolean[arr.length];
        
        for(int i = 2; i < arr.length; i++) {
        	int a = arr[i-2];
        	int b = arr[i-1];
        	int c = arr[i];
        	
        	//증가누적
        	if(a < b && b < c) {
        		dp[i][0] = dp[i-1][0] + 1;
        	}
        	
        	//꺽기는 부분
        	if(a < b && b > c) {
        		dp[i-1][0] = Math.min(i , dp[i-1][0] + 1) % temp;
        		dp[i-1][1] = Math.max(i , dp[i-1][1] + 1) % temp;
        		isCheck[i-1] = true;
        	}
        	
        	//감소누적
        	if(a > b && b > c) {
        		dp[i][1] = dp[i-1][1] + 1;
        	}
        	
        }
        
        for(int i = 0; i < arr.length-2; i++) {
        	int a = arr[i];
        	int b = arr[i+1];
        	int c = arr[i+2];
        	//감소누적
        	if(isCheck[i] && a > b && b > c) {
        		dp[i][1] = dp[i-1][1] + 1;
        	}
        }
        
        System.out.println(Arrays.toString(arr));
        
        for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
        for (int i = 0; i < isCheck.length; i++) {
			if(isCheck[i]) {
				answer = Math.max((dp[i][0] + dp[i][1]) , answer);
			}
		}
        return answer;
    }*/
}
