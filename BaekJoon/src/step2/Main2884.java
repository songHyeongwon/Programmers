package step2;

import java.util.Date;
import java.util.Scanner;

public class Main2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		Date date = new Date();
		
		date.setHours(a);
		date.setMinutes(b-45);

		System.out.println(date.getHours() +" " +date.getMinutes());
		sc.close();
	}
}
