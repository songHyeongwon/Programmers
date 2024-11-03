package step52;

import java.util.Scanner;

public class Main3003 {
	public static void main(String[] args) {
		int[] arr = new int[]{1,1,2,2,2,8};
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i] - sc.nextInt();
			System.out.print(temp + " ");
		}
		sc.close();
	}
}
