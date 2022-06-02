package step09;

import java.util.Scanner;

public class Main10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getPi(0, 1, 2 ,n));
		sc.close();
	}

	private static int getPi(int a, int b, int cnt, int n) {
		// TODO Auto-generated method stub
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(cnt == n) return a+b;
		return getPi(b , a+b, cnt+1, n);
	}
}
