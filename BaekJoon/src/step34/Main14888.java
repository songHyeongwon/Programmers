package step34;

import java.util.Scanner;

public class Main14888 {
	static int[] numArr = null;
	static int[] dustks = new int[4];
	static char[] charArr = new char[] { '+', '-', '*', '/' };

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		numArr = new int[n];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = sc.nextInt();
		}
		for (int i = 0; i < dustks.length; i++) {
			dustks[i] = sc.nextInt();
		}
		sc.close();
		getDfs(1, numArr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	private static void getDfs(int dip, int sum) {
		if (dip == numArr.length) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < dustks.length; i++) {
			if (dustks[i] > 0) {
				dustks[i]--;
				getDfs(dip + 1, getSum(charArr[i], sum, numArr[dip]));
				dustks[i]++;
			}
		}
	}

	private static int getSum(char c, int result, int nextNum) {
		switch (c) {
		case '+':
			result += nextNum;
			break;
		case '-':
			result -= nextNum;
			break;
		case '*':
			result *= nextNum;
			break;
		case '/':
			result /= nextNum;
			break;
		}
		return result;
	}
}
