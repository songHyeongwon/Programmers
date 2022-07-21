package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(n >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i = 3; i <= n; i++) {
			//직전까지 먹고 이번에 안먹음
			//앞앞까지먹고 직전 쉬고 이번에 먹음
			//두번 쉬고 앞잔과 이번잔까지 먹음
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i] , dp[i-3] + arr[i-1] + arr[i]));
		}
		System.out.println(dp[n]);
	}
}
