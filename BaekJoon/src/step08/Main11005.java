package step08;

import java.util.Scanner;

public class Main11005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int b = sc.nextInt();

		StringBuffer buf = new StringBuffer();
		while (n > 0) {
			if (n % b >= 10) {
				buf.append((char) ((n % b) + 55));
			} else {
				buf.append(n % b);
			}
			n /= b;
		}
		System.out.println(buf.reverse().toString());
		sc.close();
	}
}
