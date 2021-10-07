package step1;

import java.util.Scanner;

public class Main2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String k = sc.next();
		
		for(int i =k.length()-1; i >= 0 ; i--) {
			System.out.println(a * Character.getNumericValue(k.charAt(i)));
		}
		System.out.println(a * Integer.parseInt(k));
		sc.close();
	}
}
