package step16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		int[] dp = new int[N];
		int line = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			map.put(arr[i], sc.nextInt());
		}
		Arrays.sort(arr);

		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (map.get(arr[i]) > map.get(arr[j])) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			line = Math.max(line, dp[i]);
		}
		System.out.println(N - line);
		sc.close();
	}
}
