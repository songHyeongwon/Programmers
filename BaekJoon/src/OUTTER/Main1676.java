package OUTTER;

import java.util.Scanner;

public class Main1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;

		while(N >= 5) {
			count += N/5;
			N /=5;
		}
		System.out.println(count); 
		sc.close();
	}
}
