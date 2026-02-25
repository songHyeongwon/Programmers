package OUTTER;

import java.util.Scanner;

public class Main1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int outNum = 0;
		for (int i = 1; i <= N; i++) {
			if (isCheck(i)) {
				outNum++;
			}
		}
		sc.close();
		System.out.println(outNum);
	}

	private static boolean isCheck(int num) {
		String temp = String.valueOf(num);
		if (temp.length() < 2) {
			return true;
		}

		for (int i = 0; i <= 9; i++) {
			boolean result = false;

			for (int j = 1; j < temp.length(); j++) {
				if ((Character.getNumericValue(temp.charAt(j - 1)) + i) == Character.getNumericValue(temp.charAt(j))) {
					result = true;
				} else {
					result = false;
					break;
				}
			}

			if (result) {
				// System.out.println(num+" = "+(i)+"의 증가 등차수열");
				return true;
			}

			for (int j = 1; j < temp.length(); j++) {
				if ((Character.getNumericValue(temp.charAt(j - 1)) - i) == Character.getNumericValue(temp.charAt(j))) {
					result = true;
				} else {
					result = false;
					break;
				}
			}

			if (result) {
				// System.out.println(num+" = "+(i)+"의 감소 등차수열");
				return true;
			}
		}

		return false;
	}
}
