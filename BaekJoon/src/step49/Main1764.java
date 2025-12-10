package step49;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1764 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Set<String> set = new HashSet<String>();
		StringBuffer buf = new StringBuffer();
		ArrayList<String> arr = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			set.add(sc.next());
		}
		for (int i = 0; i < m; i++) {
			String mName = sc.next();
			if (set.contains(mName)) {
				arr.add(mName);
			}
		}
		Collections.sort(arr);
		for (String s : arr) {
			buf.append(s + "\n");
		}
		System.out.println(arr.size());
		System.out.println(buf.toString());
		sc.close();
	}
}
