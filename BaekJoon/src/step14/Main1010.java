package step14;

import java.util.Scanner;

public class Main1010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int NUM = sc.nextInt();
		
		for (int i = 0; i < NUM; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			long temp = 1;
			if(N != M) {
				int b = 1;
				while(N > 0) {
					temp = temp * M / b; // 29 / 1 * 
					b++;
					M--;
					N--;
				}
			}
			System.out.println(temp);
		}
		sc.close();
	}
}
