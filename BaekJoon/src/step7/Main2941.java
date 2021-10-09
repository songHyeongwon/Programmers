package step7;

import java.util.Scanner;

public class Main2941 {
	public static void main(String[] args) {
		String[] arr = {"c=" , "c-" , "dz=" , "d-" , "lj" , "nj", "s=" , "z="};
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		for (int i = 0; i < arr.length; i++) {
			temp = temp.replaceAll(arr[i], "0");
		}
		System.out.println(temp.length());
		sc.close();
	}
}
