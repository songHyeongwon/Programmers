package step09;

import java.util.Scanner;

public class Main1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			System.out.println(outPrint(x1, y1, r1, x2, y2, r2));
		}
		sc.close();
	}

	private static int outPrint(int x1, int y1, int r1, int x2, int y2, int r2) {
		int pow = (int) (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		
		if(x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;// CASE1
		} else if(pow > Math.pow(r2 + r1, 2)) {
			return 0;//CASE 2-1
		} else if(pow < Math.pow(r2 - r1, 2)) {
			return 0;//CASE 2-2
		} else if(pow == Math.pow(r2 - r1, 2)) {
			return 1;//CASE 3-1
		} else if(pow == Math.pow(r2 + r1, 2)) {
			return 1;//CASE 3-1
		} else {
			return 2;
		}
	}
}
