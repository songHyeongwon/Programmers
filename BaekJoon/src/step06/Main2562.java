package step06;

import java.util.Scanner;

public class Main2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int idx = 0;

		for (int i = 0; i < 9; i++) {
			int temp = sc.nextInt();
			if (max < temp) {
				max = temp;
				idx = i + 1;
			}
		}

		System.out.println(max);
		System.out.println(idx);
		sc.close();
	}
}
