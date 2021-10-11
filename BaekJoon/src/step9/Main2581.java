package step9;

import java.util.Scanner;

public class Main2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int min = 0;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			if(getCheck(i)) {
				sum+=i;
				if(min==0) {
					min = i;
				}
			}
		}
		if(min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
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
