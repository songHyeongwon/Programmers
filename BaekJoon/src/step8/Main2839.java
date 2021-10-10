package step8;

import java.util.Scanner;

public class Main2839 {
	public static void main(String[] args) {
		int b1 = 3;
		int b2 = 5;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 5000; //최대값
		for (int i = 0; i*b1 <= n; i++) {
			for (int j = 0; j*b2 <= n; j++) {
				if(n == (i*b1 + j*b2)) {
					result = Math.min(result, (i+j));
				}
			}
		}
		//값을 찾지 못했다면 -1
		if(result == 5000) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		sc.close();
	}
}
