package OUTTER;

import java.util.Scanner;

public class Main2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		int ans1 = 0;//최대공약수
		int ans2 = 0;//최소공배수
		for (int i = 1; i <= min; i++) {
			if(min % i == 0 && max % i == 0) {
				ans1 = i;
			}
		}
		
		for (int i = 1; i <= max; i++) {
			if(min * i % max == 0) {
				ans2 = min * i;
				break;
			} 
		}
		System.out.println(ans1);
		System.out.println(ans2);//최소 공배수
	}
}
