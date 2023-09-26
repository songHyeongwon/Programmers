package step06;

import java.util.Scanner;

public class Main1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double sum = 0;
		double max = 0;
		for(int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			sum += temp;
			max = Math.max(max, temp);
		}
		System.out.println((sum / (max*n) ) * 100);
		sc.close();
	}
}
