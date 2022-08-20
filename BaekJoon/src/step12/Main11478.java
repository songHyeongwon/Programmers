package step12;

import java.util.HashSet;
import java.util.Scanner;

public class Main11478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 1; i <= s.length(); i++) {
			for(int k = 0; k + i <= s.length(); k++) {
				set.add(s.substring(k, k + i));
			}
		}
		System.out.println(set.size());
		sc.close();
	}
}
