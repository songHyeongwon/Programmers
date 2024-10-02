package step49;

import java.util.HashMap;
import java.util.Scanner;

public class Main1269 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a + b; i++) {
			int t = sc.nextInt();
			if(map.containsKey(t)) {
				map.put(t, map.get(t) + 1);
			} else {
				map.put(t, 1);
			}
		}
		int count = 0;
		for(Integer t : map.keySet()) {
			if(map.get(t) == 1) count++;
		}
		System.out.println(count);
		sc.close();
	}
}
