package step07;

import java.util.Scanner;

public class Main2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String S = sc.next();
			StringBuffer buf = new StringBuffer();
			
			for (int j = 0; j < S.length(); j++) {
				for (int j2 = 0; j2 < R; j2++) {
					buf.append(S.charAt(j));
				}
			}
			System.out.println(buf.toString());
		}
		
		sc.close();
	}
}
