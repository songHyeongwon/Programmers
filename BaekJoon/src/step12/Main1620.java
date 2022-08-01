package step12;

import java.util.HashMap;
import java.util.Scanner;

public class Main1620 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer buf = new StringBuffer();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<String, Integer> numMap = new HashMap<String, Integer>();
		HashMap<Integer, String> nameMap = new HashMap<Integer, String>();
		
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String name = sc.nextLine();
			numMap.put(name, i + 1);
			nameMap.put(i + 1, name);
		}
		for (int i = 0; i < m; i++) {
			String name = sc.nextLine();
			int num = -1;
			try {
				num = Integer.parseInt(name);
				buf.append(nameMap.get(num) + "\n");
			}catch (NumberFormatException e) {
				buf.append(numMap.get(name) + "\n");
			}
		}
		sc.close();
		System.out.println(buf.toString());
	}
}
