package step08;

import java.util.Scanner;

public class Main1011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int fit = y-x; //거리
			int max = (int)Math.sqrt(fit); //최대속도
			
			if(fit == max * max) {
				System.out.println(max * 2 - 1);
			} else if(fit <= max * max + max){
				System.out.println(max * 2);
			} else {
				System.out.println(max * 2 + 1);
			}
			
		}
	}
}
