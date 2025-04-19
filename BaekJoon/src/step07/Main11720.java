package step07;

import java.util.Scanner;

public class Main11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String temp = sc.next();
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Character.getNumericValue(temp.charAt(i));
		}
		System.out.println(sum);
		sc.close();
	}
}
