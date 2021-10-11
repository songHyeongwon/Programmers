package step9;

import java.util.Scanner;

public class Main1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(getCheck(sc.nextInt())) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}

	private static boolean getCheck(int nextInt) {
		if(nextInt == 1) return false;
		
		for (int i = 2; i <= Math.sqrt(nextInt); i++) {
			if(nextInt % i == 0) return false;
		}
		
		return true;
	}
}
