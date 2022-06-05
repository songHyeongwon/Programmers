package step11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		sc.close();
		Character[] arr = new Character[n.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = n.charAt(i);
		}
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
