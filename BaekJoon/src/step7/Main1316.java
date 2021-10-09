package step7;

import java.util.HashSet;
import java.util.Scanner;

public class Main1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			String a = sc.next();
			if(isChaek(a)) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
	private static boolean isChaek(String a) {
		// TODO Auto-generated method stub
		HashSet<Character> set = new HashSet<Character>();
		char temp = a.charAt(0);
		set.add(temp);
		
		for (int i = 1; i < a.length(); i++) {
			char thisTemp = a.charAt(i);
			if(temp == thisTemp || set.add(thisTemp)) {
				temp = thisTemp;
			} else {
				return false;
			}
		}
		return true;
	}
}
