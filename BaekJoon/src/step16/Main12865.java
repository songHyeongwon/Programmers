package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

		int[] W = new int[N + 1]; // 무게배열
		int[] V = new int[N + 1]; // 가치

		for (int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(token.nextToken());
			V[i] = Integer.parseInt(token.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				// 못담는다
				if (W[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
