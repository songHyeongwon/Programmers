package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11053 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		int max = 0;
		StringTokenizer token = new StringTokenizer(br.readLine() , " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] +1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		br.close();
	}
}
