package step33;

import java.util.Scanner;

public class Main11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			int coin = arr[arr.length -1 -i];
			count += K/coin;
			K = K%coin;
		}
		
		System.out.println(count);
		sc.close();
	}
}
