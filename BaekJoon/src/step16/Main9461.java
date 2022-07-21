package step16;

import java.util.Scanner;

public class Main9461 {
	public static void main(String[] args) {
		long[] arr = new long[101];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 2;
		arr[5] = 3;
		for (int i = 6; i < arr.length; i++) {
			arr[i] = arr[i-3] + arr[i-2];
		}		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		while (n-- > 0) {
			System.out.println(arr[sc.nextInt()-1]);
		}
		
		sc.close();
	}
}
