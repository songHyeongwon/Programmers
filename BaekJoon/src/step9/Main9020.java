package step9;

import java.util.Scanner;

public class Main9020 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int a = 0;
			int b = n;
			for (int j = n-1; j >= 2; j--) {
				if(isCheck(j) && isCheck(n-j)) {
					if( Math.abs(b-a) > Math.abs(j - (n-j))) {
						b = Math.max(j, (n-j));
						a = Math.min(j, (n-j));
					}
				}
			}
			System.out.println(a + " " + b);
			
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
