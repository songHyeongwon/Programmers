package step06;

import java.util.Scanner;

public class Main10811 {
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
			arrSort(arr, k, j);
		}

		StringBuffer buf = new StringBuffer();
		for (int temp : arr) {
			buf.append(temp + " ");
		}
		System.out.println(buf.toString().trim());
		sc.close();
	}

	public static void arrSort(int[] arr, int a, int b) {
		if (b - a == 0)
			return;

		int[] temp = new int[b - a + 1];
		int idx = 0;
		for (int i = a; i <= b; i++) {
			temp[idx++] = arr[i - 1];
		}
		idx = temp.length - 1;
		for (int i = a; i <= b; i++) {
			arr[i - 1] = temp[idx--];
		}
	}
}
