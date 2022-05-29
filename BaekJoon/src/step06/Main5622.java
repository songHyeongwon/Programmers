package step06;

import java.util.Scanner;

public class Main5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = {"" , "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS","TUV","WXYZ"};
		
		int timeSum = 0;
		String q = sc.nextLine();
		int count = 0;
		while(count != q.length()) {
			String k = q.charAt(count)+"";
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].indexOf(k) > -1) {
					timeSum += i+2;
					count++;
					break;
				}
			}
			
		}
		System.out.println(timeSum);
		sc.close();
	}
}
