package step06;

import java.util.Scanner;

public class Main10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == v) count++;
		}
		System.out.println(count);
		sc.close();
	}
}
