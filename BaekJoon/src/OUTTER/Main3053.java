package OUTTER;

import java.util.Scanner;

public class Main3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		sc.close();
		
		System.out.println(Math.PI * (R*R));
		System.out.println((double)2 * R * R);
	}
}
