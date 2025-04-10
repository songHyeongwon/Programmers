package step07;

import java.util.Scanner;

public class Main1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		
		String[] aArr = a.trim().split(" ");
		
		if(aArr[0].equals("")) {
			System.out.println(0);
		} else {
			System.out.println(aArr.length);
		}
		
		
		sc.close();
	}
}
