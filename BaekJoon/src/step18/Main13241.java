package step18;

import java.util.Scanner;

public class Main13241 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num1 = sc.nextLong(); 
		long num2 = sc.nextLong();

		long gcd = getGCD(Math.max(num1, num2), Math.min(num1, num2));

		System.out.println((num1 * num2) / gcd);
		sc.close();
	}

	public static long getGCD(long a, long b) {
		while (b > 0) {
			long tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
}
