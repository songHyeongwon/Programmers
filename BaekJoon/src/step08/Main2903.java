package step08;

import java.util.Scanner;

public class Main2903 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println((long) Math.pow(Math.pow(2, t) + 1, 2));
		sc.close();
	}
}
