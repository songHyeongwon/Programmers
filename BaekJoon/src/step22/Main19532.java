package step22;

import java.util.Scanner;

public class Main19532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, e, d, f;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		e = sc.nextInt();
		f = sc.nextInt();
		int answerX = 0;
		int answerY = 0;
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if ((a * i + b * j == c) && (d * i + e * j == f)) {
					answerX = i;
					answerY = j;
					break;
				}
			}
		}
		System.out.println(answerX + " " + answerY);

		sc.close();
	}
}
