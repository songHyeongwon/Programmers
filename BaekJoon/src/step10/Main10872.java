package step10;

import java.util.Scanner;

public class Main10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getPack(n, 1));
		sc.close();
	}

	private static int getPack(int n, int temp) {
		if(n == 0) return temp;
		return getPack(n-1 , temp *= n);
	}
}
