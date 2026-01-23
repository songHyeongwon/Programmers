package OUTTER;

import java.util.Scanner;

public class Main2577 {
	public static void main(String[] args) {
		int[] intArr = new int[10];
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		long temp = a*b*c;
		String k = temp+"";
		
		for (int i = 0; i < k.length(); i++) {
			intArr[Character.getNumericValue(k.charAt(i))]++;
		}
		for(int arr : intArr) {
			System.out.println(arr);
		} 
		sc.close();
	}
}
