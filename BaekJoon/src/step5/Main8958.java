package step5;

import java.util.Scanner;

public class Main8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			int point = 0;
			int oCnt = 0;
			for (int j = 0; j < temp.length(); j++) {
				if(temp.charAt(j) == 'O') {
					oCnt++;
					point += oCnt;
				} else {
					oCnt = 0;
				}
			}
			System.out.println(point);
		}
		sc.close();
	}
}
