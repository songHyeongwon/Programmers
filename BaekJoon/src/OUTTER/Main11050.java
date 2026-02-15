package OUTTER;

import java.util.Scanner;

public class Main11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		System.out.println(BC(N, K));
	}
	private static int BC(int n, int k) {
		if(n==k || k==0) {
			return 1;
		}
		return BC(n-1 , k-1) + BC(n-1,k);
	} 
}
