package step29;

import java.util.HashMap;
import java.util.Scanner;

public class Main10816 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			if (map.containsKey(t)) {
				map.put(t, map.get(t) + 1);
			} else {
				map.put(t, 1);
			}
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int t = sc.nextInt();
			if (map.containsKey(t)) {
				buf.append(map.get(t) + " ");
			} else {
				buf.append(0 + " ");
			}
		}
		System.out.println(buf.toString());
		sc.close();
	}
}
