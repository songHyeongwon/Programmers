package step06;

import java.util.Scanner;

public class Main10810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < m; i++) {
			int t = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();

			for (int k2 = t; k2 <= j; k2++) {
				arr[k2 - 1] = k;
			}
		}
		String out = "";
		for (int temp : arr) {
			out += temp + " ";
		}
		System.out.println(out.trim());
		sc.close();
	}
}
