package step10;

import java.util.Scanner;

public class Main5086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a+b ==0) break;
			
			String result = "neither";
			if(a % b == 0) {
				result = "multiple";
			}
			if(b % a == 0) {
				result = "factor";
			}
			System.out.println(result);
		}
		sc.close();
	}
}
