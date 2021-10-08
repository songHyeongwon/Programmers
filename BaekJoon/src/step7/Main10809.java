package step7;

import java.util.Scanner;

public class Main10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char k = 'a';
		for (int i = 0; i < 26; i++) {
			System.out.print(s.indexOf(k+i) + " ");
		}
		sc.close();
	}
}
