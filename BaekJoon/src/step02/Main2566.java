package step02;

import java.util.Scanner;

public class Main2566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int x = 0;
		int y = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int temp = sc.nextInt();
				max = Math.max(max, temp);
				if (max == temp) {
					x = i + 1;
					y = j + 1;
				}
			}
		}
		sc.close();
		System.out.println(max);
		System.out.println(x + " " + y);

	}
}
