package step07;

import java.util.Scanner;

public class Main9086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < row; i++) {
			String stg = sc.nextLine();
			System.out.print(stg.charAt(0));
			System.out.println(stg.charAt(stg.length() - 1));
		}
		sc.close();
	}
}
