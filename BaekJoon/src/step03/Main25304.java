package step03;

import java.util.Scanner;

public class Main25304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			x -= a*b;
		}
		sc.close();
		if(x==0) System.out.println("Yes");
		else System.out.println("No");
		
	}
}
