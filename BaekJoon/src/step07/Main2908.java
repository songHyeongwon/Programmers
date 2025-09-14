package step07;

import java.util.Scanner;

public class Main2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		char[] aArr = new char[a.length()];
		char[] bArr = new char[b.length()];
		for (int i = 0; i < aArr.length; i++) {
			aArr[i] = a.charAt(a.length() - 1 - i);
		}
		for (int i = 0; i < bArr.length; i++) {
			bArr[i] = b.charAt(b.length() - 1 - i);
		}

		a = new String(aArr);
		b = new String(bArr);

		if (Integer.parseInt(a) > Integer.parseInt(b)) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}

		sc.close();
	}
}
