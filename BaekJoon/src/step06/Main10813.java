package step06;

import java.util.Scanner;

public class Main10813 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			int j = sc.nextInt();
			int temp = arr[k - 1];
			arr[k - 1] = arr[j - 1];
			arr[j - 1] = temp;
		}

		StringBuffer buf = new StringBuffer();
		for (int temp : arr) {
			buf.append(temp + " ");
		}
		System.out.println(buf.toString().trim());
		sc.close();
	}
}
