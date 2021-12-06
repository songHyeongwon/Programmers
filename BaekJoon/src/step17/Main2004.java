package step17;

import java.util.Scanner;

public class Main2004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int count5 = five(n) - five(n-m) - five(m);
		int count2 = tow(n) - tow(n-m) - tow(m);
		
		System.out.println(Math.min(count5, count2));
		sc.close();
	}
	public static int five(int a) {
		int count = 0;
		while(a >= 5) {
			count += a/5;
			a /= 5;
		}
		return count;
	}
	public static int tow(int a) {
		int count = 0;
		while(a >= 2) {
			count += a/2;
			a /= 2;
		}
		return count;
	}
}
