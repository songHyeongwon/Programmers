package step9;

import java.util.Scanner;

public class Main1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		for (int i = M; i <= N; i++) {
			if(getCheck(i)) {
				System.out.println(i);
			}
		}
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
