package step22;

import java.util.Scanner;

public class Main1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int cnt = 0;
		int endNum = 666;

		while (cnt != N) {
			if (String.valueOf(endNum).contains("666")) {
				cnt++;
			}
			endNum++;
		}
		System.out.println(endNum - 1);
	}
}
