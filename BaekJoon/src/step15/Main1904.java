package step15;

import java.util.Scanner;

public class Main1904 {
	public static void main(String[] args) {
		int[] arr = new int[1000001];
		
		arr[0] = 1;
		arr[1] = 2;
		
		for (int i = 2; i < arr.length; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 15746;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println(arr[sc.nextInt()-1]);
		sc.close();
	}
}
