package step09;

import java.util.Arrays;
import java.util.Scanner;

public class Main2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}
