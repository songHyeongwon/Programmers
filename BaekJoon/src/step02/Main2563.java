package step02;

import java.util.Scanner;

public class Main2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean[][] isCheck = new boolean[100][100];
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					isCheck[j][k] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < isCheck.length; i++) {
			for (int j = 0; j < isCheck[i].length; j++) {
				if(isCheck[i][j]) count++;
			}
		}
		
		System.out.println(count);
		sc.close();
	}
}
