package step08;

import java.util.Scanner;

public class Main2720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr = { 25, 10, 5, 1 };
		for (int i = 0; i < t; i++) {
			int s = sc.nextInt();
			for (int j = 0; j < arr.length; j++) {
				System.out.print((s / arr[j]));
				s %= arr[j];
				if (j != arr.length - 1) {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
		sc.close();
	}
}
