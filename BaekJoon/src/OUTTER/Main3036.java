package OUTTER;

import java.util.Scanner;

public class Main3036 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int rollCnt = sc.nextInt();
		for (int i = 1; i < N; i++) {
			int temp = sc.nextInt();
			int gcd = gcd(temp , rollCnt);
			System.out.print(rollCnt / gcd);
			System.out.print("/");
			System.out.println(temp / gcd);
		}
		
		sc.close();
	} 
	//최대공약수 
	private static int gcd(int a, int b) {
		while(b != 0) {
			int r =a % b;
			a=b;
			b=r;
		}
		return a;
	}
}
