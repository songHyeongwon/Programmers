package OUTTER;

import java.util.Scanner;

public class Main1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String temp = a;
		int count = 0;
		while (true) {
			count++;
			if(temp.length() < 2) {
				temp = "0" + temp;
			}
			String c = Character.getNumericValue(temp.charAt(0)) + Character.getNumericValue(temp.charAt(1)) + "";
			temp = temp.charAt(1) + "" + c.charAt(c.length()-1);
			temp = Integer.parseInt(temp) + "";
			if(temp.equals(a)) {
				break;
			}
		}
		System.out.println(count); 
		sc.close();
	}
}
