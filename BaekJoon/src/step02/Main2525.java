package step02;

import java.util.Scanner;

public class Main2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int m = sc.nextInt();
		int next = sc.nextInt();
		sc.close();
		int temp = H * 60 + m + next;
		int nextM = temp%60;
		int nextH = (temp - temp%60) / 60;
		System.out.println(nextH%24 + " " + nextM);
	}
}
