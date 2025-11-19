package step22;

import java.util.Scanner;

public class Main2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int result = 0;

		for (int i = n - 1; i > 0; i--) {
			int temp = getTemp(i);
			if (temp == n) {
				result = i;
			}
		}
		sc.close();
		System.out.println(result);
	}

	private static int getTemp(int i) {
		String s = i + "";
		for (int j = 0; j < s.length(); j++) {
			i += Character.getNumericValue(s.charAt(j));
		}
		return i;
	}
}
