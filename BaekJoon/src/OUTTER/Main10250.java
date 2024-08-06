package OUTTER;

import java.util.Scanner;

public class Main10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			//N = N % W;
			//이 부분의 W는 못지우겠다
			if(N % H ==0) {
				System.out.print(H);
				int k = N/H;
				if(k < 10) {
					System.out.println("0" + k);
				} else {
					System.out.println(k);
				}
			} else {
				System.out.print(N % H);
				int k = N/H +1;
				if(k < 10) {
					System.out.println("0" + k);
				} else {
					System.out.println(k);
				}
			}
			
		}
		sc.close();
	}
}
