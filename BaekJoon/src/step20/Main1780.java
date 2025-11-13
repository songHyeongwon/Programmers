package step20;

import java.util.Scanner;

public class Main1780 {
	static int[][] arr = null;
	static int N;

	static int countMinus = 0;
	static int countPlus = 0;
	static int countZero = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		findRow(0, 0, N);
		System.out.println(countMinus);
		System.out.println(countZero);
		System.out.println(countPlus);
	}

	public static void findRow(int y, int x, int n) {
		int temp = arr[y][x];
		boolean isCheck = getIsCheck(y, x, n);
		if (isCheck && n > 1) {
			int cntN = n / 3;
			for (int i = 0; i < n; i += cntN) {
				for (int j = 0; j < n; j += cntN) {
					findRow(y + i, x + j, cntN);
				}
			}
		} else {
			switch (temp) {
			case 0:
				countZero++;
				break;
			case 1:
				countPlus++;
				break;
			case -1:
				countMinus++;
				break;
			}
			return;
		}
	}

	public static boolean getIsCheck(int y, int x, int n) {
		int temp = arr[y][x];
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (temp != arr[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
