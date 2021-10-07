package step3;

import java.util.Scanner;

public class Main11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for (int i = 1; i <= a; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(String.format("Case #%d: %d + %d = %d", i , x,y,x+y));
		}
		sc.close();
	}
}
