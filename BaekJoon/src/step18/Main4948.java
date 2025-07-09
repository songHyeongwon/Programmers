package step18;

import java.util.Scanner;

public class Main4948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int count = 0;
			int n = sc.nextInt();
			if(n == 0) break;
			 
			for (int i = n+1; i <= n*2; i++) {
				if(isCheck(i)) count++;
			}
			System.out.println(count);
		}
		sc.close();
	}
	private static boolean isCheck(int nextInt) {
		if(nextInt == 1) return false;
		
		for (int i = 2; i <= Math.sqrt(nextInt); i++) {
			if(nextInt % i == 0) return false;
		}
		
		return true;
	}
}
