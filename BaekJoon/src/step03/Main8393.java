package step03;

import java.util.Scanner;

public class Main8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		long temp = 0;
		for (int i = 1; i <= a; i++) {
			temp += i ;
		}
		System.out.println(temp);
		sc.close();
		
	}
}
