package step52;

import java.util.Scanner;

public class Main2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String k = new StringBuilder(t).reverse().toString();
		if(t.equals(k)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		sc.close();
	}
}
