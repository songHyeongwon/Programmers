package step49;

import java.util.HashSet;
import java.util.Scanner;

public class Main10815 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			if(set.contains(sc.nextInt())) {
				buf.append("1 ");
			} else {
				buf.append("0 ");
			}
		}
		sc.close();
		System.out.println(buf.toString());
	}
}
