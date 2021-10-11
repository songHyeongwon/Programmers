package step08;

import java.util.Scanner;

public class Main2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		int result = 1;
		while(n > count) {
			count += (6*result);
			result++;
		}
		System.out.println(result);
		sc.close();
	}
}
