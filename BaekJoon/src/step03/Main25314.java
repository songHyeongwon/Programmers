package step03;

import java.util.Scanner;

public class Main25314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < n; i += 4) {
			buf.append("long ");
		}
		buf.append("int");
		System.out.println(buf.toString());
		sc.close();

	}
}
